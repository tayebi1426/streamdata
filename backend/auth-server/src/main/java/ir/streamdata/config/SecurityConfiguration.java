package ir.streamdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService(JdbcTemplate jdbcTemplate) {
        return new JdbcUserDetailsService(jdbcTemplate);
    }

    @Bean
    TokenEnhancer tokenEnhancer(UserDetailsService userDetailsService) {
        return new UserTokenEnhancer(userDetailsService);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}