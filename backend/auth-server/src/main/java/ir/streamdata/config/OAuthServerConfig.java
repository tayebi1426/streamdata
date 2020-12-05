package ir.streamdata.config;

import ir.streamdata.props.AuthServerProps;
import ir.streamdata.service.impl.JdbcUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class OAuthServerConfig extends AuthorizationServerConfigurerAdapter {

    private final AccessTokenConverter accessTokenConverter;
    private final List<TokenEnhancer> tokenEnhancerList;
    private final TokenStore tokenStore;
    private final AuthenticationManager authenticationManager;
    private final AuthServerProps authServerProps;

    public OAuthServerConfig(AccessTokenConverter accessTokenConverter,
                             List<TokenEnhancer> tokenEnhancerList,
                             TokenStore tokenStore,
                             AuthenticationManager authenticationManager,
                             AuthServerProps authServerProps) {
        this.accessTokenConverter = accessTokenConverter;
        this.tokenEnhancerList = tokenEnhancerList;
        this.tokenStore = tokenStore;
        this.authenticationManager = authenticationManager;
        this.authServerProps = authServerProps;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client_id")
                .secret(passwordEncoder().encode("client_secret"))
                .authorizedGrantTypes("password","refresh_token")
                .scopes("user_info")
                .autoApprove(true);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager)
                .tokenServices(tokenServices())
                .tokenEnhancer(tokenEnhancerChain())
                .accessTokenConverter(accessTokenConverter);
    }

    @Bean
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore);
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setReuseRefreshToken(true);
        tokenServices.setAccessTokenValiditySeconds(authServerProps.getToken().getAccessValiditySeconds());
        tokenServices.setTokenEnhancer(tokenEnhancerChain());
        //tokenServices.setClientDetailsService(clientDetailsService());
        return tokenServices;
    }

    @Bean
    TokenEnhancerChain tokenEnhancerChain() {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(tokenEnhancerList);
        return tokenEnhancerChain;
    }

    @Bean
    public UserDetailsService userDetailsService(JdbcTemplate jdbcTemplate) {
        return new JdbcUserDetailsService(jdbcTemplate);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
