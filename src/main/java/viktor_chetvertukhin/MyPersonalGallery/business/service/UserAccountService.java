package viktor_chetvertukhin.MyPersonalGallery.business.service;

import viktor_chetvertukhin.MyPersonalGallery.dto.AuthorizationToken;
import viktor_chetvertukhin.MyPersonalGallery.dto.RequestAuth;

import java.security.Principal;

public interface UserAccountService {
    Integer userLikePicture(Principal principal, Long id);

    Integer userUnlikePicture(Principal principal, Long id);

    public AuthorizationToken authenticationUser(RequestAuth requestAuth, String authorization);
}
