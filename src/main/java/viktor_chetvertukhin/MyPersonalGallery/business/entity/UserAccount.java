package viktor_chetvertukhin.MyPersonalGallery.business.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity(name = "usr")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserAccount implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String username;

    @NotNull
    String password;

    @ManyToMany
    @JoinTable(name = "usr_likes_picture",
                joinColumns = @JoinColumn(name = "usr_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "picture_id", referencedColumnName = "id"))
    Set<Picture> pictures;

    boolean accountNonExpired;

    boolean accountNonLocked;

    boolean credentialsNonExpired;

    boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usr_authorities",
            joinColumns = @JoinColumn(name = "usr_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    Set<Authority> authorities;

    @Override
    public Collection<Authority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void likePicture(Picture picture){
        picture.setLikes(picture.getLikes()+1);
        pictures.add(picture);
    }

    public void unlikePicture(Picture picture){
        picture.setLikes(picture.getLikes()-1);
        pictures.remove(picture);
    }
}
