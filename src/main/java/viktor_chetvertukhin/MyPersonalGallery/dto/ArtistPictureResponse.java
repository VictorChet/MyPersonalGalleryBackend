package viktor_chetvertukhin.MyPersonalGallery.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArtistPictureResponse {
    Long id;
    String name;
}
