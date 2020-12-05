package ir.streamdata.config.jwt;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import ir.streamdata.props.AuthServerProps;
import ir.streamdata.service.impl.UserTokenEnhancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Collections;

@Configuration
public class JwtTokenConfig {

    private final AuthServerProps authServerProps;

    public JwtTokenConfig(AuthServerProps authServerProps) {
        this.authServerProps = authServerProps;
    }

    @Bean
    public TokenStore tokenStore(JwtAccessTokenConverter accessTokenConverter) {
        return new JwtTokenStore(accessTokenConverter);
    }

    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new UserTokenEnhancer();
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter(KeyPair keyPair) {
        return new CustomJwtAccessTokenConverter(keyPair, Collections.singletonMap("kid", "oauth2-server-kid"));
    }

    @Bean
    KeyPair keyPair() {
        char[] passwordChars = authServerProps.getJwk().getKeystorePassword().toCharArray();
        KeyStoreKeyFactory ksFactory = new KeyStoreKeyFactory(authServerProps.getJwk().getKeystoreLocation(), passwordChars);
        return ksFactory.getKeyPair(authServerProps.getJwk().getKeystoreAlias(),passwordChars);
    }

    @Bean
    public JWKSet jwkSet() {
        RSAKey.Builder builder = new RSAKey.Builder((RSAPublicKey) keyPair().getPublic())
                .keyUse(KeyUse.SIGNATURE)
                .algorithm(JWSAlgorithm.RS256)
                .keyID("oauth2-server-kid");
        return new JWKSet(builder.build());
    }
}