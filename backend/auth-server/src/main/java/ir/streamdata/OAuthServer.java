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
@ConfigurationPropertiesScan(basePackages = "ir.streamdata.props")
public class OAuthServer {

    public static void main(String[] args) {
        //System.out.println(new BCryptPasswordEncoder().encode("Admin@1234_"));
        SpringApplication.run(OAuthServer.class, args);
    }
}
