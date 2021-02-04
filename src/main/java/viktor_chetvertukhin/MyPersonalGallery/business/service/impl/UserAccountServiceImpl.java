package viktor_chetvertukhin.MyPersonalGallery.business.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import viktor_chetvertukhin.MyPersonalGallery.business.dao.PictureRepository;
import viktor_chetvertukhin.MyPersonalGallery.business.dao.UserAccountRepository;
import viktor_chetvertukhin.MyPersonalGallery.business.entity.Picture;
import viktor_chetvertukhin.MyPersonalGallery.business.entity.UserAccount;
import viktor_chetvertukhin.MyPersonalGallery.business.service.UserAccountService;
import viktor_chetvertukhin.MyPersonalGallery.dto.AuthorizationToken;
import viktor_chetvertukhin.MyPersonalGallery.dto.RequestAuth;
import viktor_chetvertukhin.MyPersonalGallery.helpers.ObjectToUrlEncodedConverter;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final PictureRepository pictureRepository;

    private final UserAccountRepository userAccountRepository;

    @Override
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Integer userLikePicture(Principal principal, Long id) {
        Picture picture = pictureRepository.getById(id);
        UserAccount userAccount = userAccountRepository.getUserAccountByUsername(principal.getName());
        userAccount.likePicture(picture);
        pictureRepository.save(picture);
        userAccountRepository.save(userAccount);
        return picture.getLikes();
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Integer userUnlikePicture(Principal principal, Long id) {
        Picture picture = pictureRepository.getById(id);
        UserAccount userAccount = userAccountRepository.getUserAccountByUsername(principal.getName());
        userAccount.unlikePicture(picture);
        pictureRepository.save(picture);
        userAccountRepository.save(userAccount);
        return picture.getLikes();
    }

    @Override
    public AuthorizationToken authenticationUser(RequestAuth requestAuth, String authorization) {
        String uri = "http://localhost:8082/oauth/token";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new ObjectToUrlEncodedConverter(new ObjectMapper()));
        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(createBody(requestAuth), createHeaders(authorization));
        return restTemplate.postForObject(uri, request , AuthorizationToken.class);
    }

    private HttpHeaders createHeaders(String authorization){
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(authorization.split(" ")[1]);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return headers;
    }

    private Map<String, Object> createBody(RequestAuth requestAuth){
        Map<String, Object> bodyRequest = new HashMap<>();
        bodyRequest.put("grant_type", requestAuth.getGrant_type());
        bodyRequest.put("username", requestAuth.getUsername());
        bodyRequest.put("password", requestAuth.getPassword());
        return bodyRequest;
    }
}
