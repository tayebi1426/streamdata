package ir.streamdata.endpoint;

import com.nimbusds.jose.jwk.JWKSet;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class JwkSetEndpoint {

    private JWKSet jwkSet;

    public JwkSetEndpoint(JWKSet jwkSet) {
        this.jwkSet = jwkSet;
    }

    @GetMapping("/.well-known/jwks.json")
    @ResponseBody
    public JSONObject getKey() {
        return jwkSet.toJSONObject();
    }
}