package viktor_chetvertukhin.MyPersonalGallery.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import viktor_chetvertukhin.MyPersonalGallery.business.service.PictureService;
import viktor_chetvertukhin.MyPersonalGallery.business.service.UserAccountService;
import viktor_chetvertukhin.MyPersonalGallery.dto.PictureMainPageResponse;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class MainPageController {

    private final PictureService pictureService;

    private final UserAccountService userAccountService;

    @GetMapping
    public List<PictureMainPageResponse> getTopSixPictures(){
        return pictureService.getTopSixPictures();
    }

    @PutMapping("/{id}/like")
    public Integer userLikePicture(@PathVariable Long id, Principal principal){
        return userAccountService.userLikePicture(principal, id);
    }

    @PutMapping("/{id}/unlike")
    public Integer userUnlikePicture(@PathVariable Long id, Principal principal){
        return userAccountService.userUnlikePicture(principal, id);
    }
}
