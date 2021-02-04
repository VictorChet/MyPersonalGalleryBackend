package viktor_chetvertukhin.MyPersonalGallery.business.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import viktor_chetvertukhin.MyPersonalGallery.business.entity.Picture;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture getById(Long id);
    List<Picture> getAllBy(Sort sort);
}
