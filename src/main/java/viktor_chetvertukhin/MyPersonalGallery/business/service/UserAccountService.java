package viktor_chetvertukhin.MyPersonalGallery.business.service;

import viktor_chetvertukhin.MyPersonalGallery.dto.AuthorizationToken;
import viktor_chetvertukhin.MyPersonalGallery.dto.RequestAuth;
import viktor_chetvertukhin.MyPersonalGallery.dto.UserResponse;

import java.security.Principal;

public interface UserAccountService {
    UserResponse getUserByUsername(String username);

    Integer userLikePicture(Principal principal, Long id);

    Integer userUnlikePicture(Principal principal, Long id);

    AuthorizationToken authenticationUser(RequestAuth requestAuth, String authorization);
}
