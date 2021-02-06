package viktor_chetvertukhin.MyPersonalGallery.web.mapper;

import org.mapstruct.Mapper;
import viktor_chetvertukhin.MyPersonalGallery.business.entity.UserAccount;
import viktor_chetvertukhin.MyPersonalGallery.dto.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserAccount, UserResponse> {
    UserResponse toDTO(UserAccount userAccount);
}

