package viktor_chetvertukhin.MyPersonalGallery.business.service;

import viktor_chetvertukhin.MyPersonalGallery.dto.ImageResponse;
import viktor_chetvertukhin.MyPersonalGallery.dto.PictureMainPageResponse;
import viktor_chetvertukhin.MyPersonalGallery.dto.PictureResponse;

import java.util.List;

public interface PictureService {
    PictureResponse getPictureById(Long id);

    List<PictureMainPageResponse> getTopSixPictures();

    ImageResponse getPictureImage(Long id);
}
