package viktor_chetvertukhin.MyPersonalGallery.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import viktor_chetvertukhin.MyPersonalGallery.business.service.PictureService;
import viktor_chetvertukhin.MyPersonalGallery.business.service.UserAccountService;
import viktor_chetvertukhin.MyPersonalGallery.dto.ImageResponse;
import viktor_chetvertukhin.MyPersonalGallery.dto.PictureResponse;

import java.security.Principal;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@RestController
@RequestMapping("/picture")
@Slf4j
public class ContentPageController {

    private final PictureService pictureService;

    @GetMapping("/{id}")
    public PictureResponse getPictureById(@PathVariable Long id){
        return pictureService.getPictureById(id);
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<String> getPictureImage(@PathVariable Long id){
        ImageResponse imageResponse = pictureService.getPictureImage(id);
        String encodeImage = Base64.getEncoder().encodeToString(imageResponse.getByteArrayResource().getByteArray());
        return ResponseEntity
                .ok()
                .cacheControl(CacheControl.maxAge(300, TimeUnit.SECONDS))
                .contentLength(encodeImage.length())
                .contentType(imageResponse.getMediaType())
                .body(encodeImage);
    }
}
