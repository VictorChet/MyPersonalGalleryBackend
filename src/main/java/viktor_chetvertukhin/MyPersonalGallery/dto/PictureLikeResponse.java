package viktor_chetvertukhin.MyPersonalGallery.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PictureLikeResponse {
    Long id;
}
