package viktor_chetvertukhin.MyPersonalGallery.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.GregorianCalendar;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PictureResponse {
    Long id;
    String name;
    String description;
    Integer year;
    String material;
    ArtistPictureResponse artist;
}
