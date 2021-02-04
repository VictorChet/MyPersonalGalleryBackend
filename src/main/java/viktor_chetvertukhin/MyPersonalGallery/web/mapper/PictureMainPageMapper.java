package viktor_chetvertukhin.MyPersonalGallery.web.mapper;

import org.mapstruct.Mapper;
import viktor_chetvertukhin.MyPersonalGallery.business.entity.Picture;
import viktor_chetvertukhin.MyPersonalGallery.dto.PictureMainPageResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PictureMainPageMapper extends GenericMapper<Picture, PictureMainPageResponse> {
    List<PictureMainPageResponse> toDTOs(List<Picture> pictures);
}
