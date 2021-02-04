package viktor_chetvertukhin.MyPersonalGallery.business.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.util.Set;

import javax.persistence.*;

@Entity(name = "artist")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String name;

    @OneToMany(mappedBy = "artist")
    Set<Picture> pictures;
}
