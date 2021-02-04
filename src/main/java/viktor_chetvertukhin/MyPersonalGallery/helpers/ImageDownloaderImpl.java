package viktor_chetvertukhin.MyPersonalGallery.helpers;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import viktor_chetvertukhin.MyPersonalGallery.dto.ImageResponse;
import viktor_chetvertukhin.MyPersonalGallery.exception.ImageNotFoundException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ImageDownloaderImpl implements ImageDownloader {

    @Override
    public ImageResponse getImage(String filepath) {
        File file = new File(filepath);
        Path path = Paths.get(file.getPath());
        try {
            ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
            String contentType = Files.probeContentType(file.toPath());
            if (contentType == null) {
                throw new ImageNotFoundException(String.format("Cannot download image with URI: %s", filepath));
            }
            return new ImageResponse(file.length(), MediaType.parseMediaType(contentType), resource);
        } catch (IOException ex) {
            throw new ImageNotFoundException(String.format("Cannot parse image with URI: %s", filepath));
        }
    }
}