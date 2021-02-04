package viktor_chetvertukhin.MyPersonalGallery.business.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity(name = "picture")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String name;

    @NotNull
    String description;

    @NotNull
    Integer year;

    @NotNull
    String material;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id")
    Artist artist;

    @NotNull
    Integer likes;

    @NotNull
    String path;
}
