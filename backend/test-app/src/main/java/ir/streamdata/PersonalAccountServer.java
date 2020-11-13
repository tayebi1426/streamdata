package ir.streamdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc()
@SpringBootApplication(scanBasePackages = "ir.streamdata")
public class PersonalAccountServer {

    public static void main(String[] args) {
        SpringApplication.run(PersonalAccountServer.class, args);
    }
}

