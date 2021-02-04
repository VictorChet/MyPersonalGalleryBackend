package viktor_chetvertukhin.MyPersonalGallery.helpers;

import viktor_chetvertukhin.MyPersonalGallery.dto.ImageResponse;

public interface ImageDownloader {
    ImageResponse getImage(String  filepath);
}
