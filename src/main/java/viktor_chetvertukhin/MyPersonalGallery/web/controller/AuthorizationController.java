package viktor_chetvertukhin.MyPersonalGallery.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import viktor_chetvertukhin.MyPersonalGallery.business.service.UserAccountService;
import viktor_chetvertukhin.MyPersonalGallery.dto.AuthorizationToken;
import viktor_chetvertukhin.MyPersonalGallery.dto.RequestAuth;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthorizationController {

    private final UserAccountService userAccountService;

    @PostMapping( "/request")
    ResponseEntity<AuthorizationToken> authorizationRequest(RequestAuth requestAuth,
                                                            @RequestHeader String authorization){
        log.info("{}, {}", requestAuth, authorization);
        return ResponseEntity.ok().body(userAccountService.authenticationUser(requestAuth, authorization));
    }
}
