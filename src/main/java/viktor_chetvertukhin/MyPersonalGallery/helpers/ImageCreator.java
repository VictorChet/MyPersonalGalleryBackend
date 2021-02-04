package viktor_chetvertukhin.MyPersonalGallery.helpers;

import org.springframework.web.multipart.MultipartFile;

public interface ImageCreator {
    void createImage(String filename, MultipartFile multipartFile);
}
