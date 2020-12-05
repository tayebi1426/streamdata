package ir.streamdata.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

@ConfigurationProperties(prefix = "streamdata.oauth-server")
@Validated
public class AuthServerProps {

    private  Token token=new AuthServerProps.Token();
    private  Jwk jwk=new AuthServerProps.Jwk();

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Jwk getJwk() {
        return jwk;
    }

    public static class Token {

        @Min(5)
        @Min(0)
        private int accessValiditySeconds = 60 * 60 * 12; // default 12 hours.
        private int refreshValiditySeconds = 60 * 60 * 24 * 30; // default 30 days.

        public int getAccessValiditySeconds() {
            return accessValiditySeconds;
        }

        public void setAccessValiditySeconds(int accessValiditySeconds) {
            this.accessValiditySeconds = accessValiditySeconds;
        }

        public int getRefreshValiditySeconds() {
            return refreshValiditySeconds;
        }

        public void setRefreshValiditySeconds(int refreshValiditySeconds) {
            this.refreshValiditySeconds = refreshValiditySeconds;
        }
    }
    public static class Jwk {
        private ClassPathResource keystoreLocation;
        private String keystoreAlias;
        private String keystorePassword;

        public ClassPathResource getKeystoreLocation() {
            return keystoreLocation;
        }

        public void setKeystoreLocation(ClassPathResource keystoreLocation) {
            this.keystoreLocation = keystoreLocation;
        }

        public String getKeystoreAlias() {
            return keystoreAlias;
        }

        public void setKeystoreAlias(String keystoreAlias) {
            this.keystoreAlias = keystoreAlias;
        }

        public String getKeystorePassword() {
            return keystorePassword;
        }

        public void setKeystorePassword(String keystorePassword) {
            this.keystorePassword = keystorePassword;
        }
    }
}
