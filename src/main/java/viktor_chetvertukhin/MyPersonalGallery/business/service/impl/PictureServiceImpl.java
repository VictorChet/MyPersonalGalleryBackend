package viktor_chetvertukhin.MyPersonalGallery.business.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import viktor_chetvertukhin.MyPersonalGallery.business.dao.PictureRepository;
import viktor_chetvertukhin.MyPersonalGallery.business.service.PictureService;
import viktor_chetvertukhin.MyPersonalGallery.dto.ImageResponse;
import viktor_chetvertukhin.MyPersonalGallery.dto.PictureMainPageResponse;
import viktor_chetvertukhin.MyPersonalGallery.dto.PictureResponse;
import viktor_chetvertukhin.MyPersonalGallery.helpers.ImageDownloader;
import viktor_chetvertukhin.MyPersonalGallery.web.mapper.PictureMainPageMapper;
import viktor_chetvertukhin.MyPersonalGallery.web.mapper.PictureMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    private final PictureMapper pictureMapper;

    private final PictureMainPageMapper pictureMainPageMapper;

    private final ImageDownloader imageDownloader;

    @Override
    public PictureResponse getPictureById(Long id) {
        return pictureMapper.toDTO(pictureRepository.getById(id));
    }

    @Override
    public List<PictureMainPageResponse> getTopSixPictures() {
        return pictureMainPageMapper.toDTOs(pictureRepository.getAllBy
                (Sort.by(Sort.Direction.DESC, "likes")).stream().limit(6).collect(Collectors.toList()));
    }

    @Override
    public ImageResponse getPictureImage(Long id) {
        return imageDownloader.getImage(pictureRepository.getById(id).getPath());
    }
}
