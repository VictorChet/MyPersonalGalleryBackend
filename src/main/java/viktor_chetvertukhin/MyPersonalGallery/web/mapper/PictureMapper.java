package viktor_chetvertukhin.MyPersonalGallery.web.mapper;

import org.mapstruct.Mapper;
import viktor_chetvertukhin.MyPersonalGallery.business.entity.Picture;
import viktor_chetvertukhin.MyPersonalGallery.dto.PictureResponse;

@Mapper(componentModel = "spring")
public interface PictureMapper extends GenericMapper<Picture, PictureResponse> {
    PictureResponse toDTO(Picture picture);
}
