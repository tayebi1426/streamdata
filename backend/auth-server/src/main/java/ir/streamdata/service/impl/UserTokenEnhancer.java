package ir.streamdata.service.impl;

import ir.streamdata.model.dto.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Collections;

public class UserTokenEnhancer implements TokenEnhancer {


    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        CustomUserDetails userDetails = getUserDetails(authentication);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(Collections.singletonMap(CustomUserDetails.USER_ID, userDetails.getId()));
        return accessToken;
    }

    private CustomUserDetails getUserDetails(OAuth2Authentication authentication) {
        Object principal = authentication.getUserAuthentication().getPrincipal();
         if (principal instanceof CustomUserDetails) {
            return (CustomUserDetails) principal;
        } else {
            throw new IllegalStateException("Unsupported principal type");
        }
    }
}
