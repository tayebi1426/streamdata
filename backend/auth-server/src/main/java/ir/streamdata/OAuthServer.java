package ir.streamdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableWebSecurity
@EnableAuthorizationServer
@SpringBootApplication(scanBasePackages = "ir.streamdata")
@ConfigurationPropertiesScan(basePackageClasses = {OAuthServer.class})
public class OAuthServer {

    public static void main(String[] args) {
        SpringApplication.run(OAuthServer.class, args);
    }
}
