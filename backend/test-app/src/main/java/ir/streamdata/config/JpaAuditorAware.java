package ir.streamdata.config;

import ir.streamdata.model.dto.CustomUserDetails;
import ir.streamdata.model.entity.security.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class JpaAuditorAware implements AuditorAware<User> {

    @Override
    public Optional<User> getCurrentAuditor() {
        CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = new User();
        currentUser.setId(principal.getId());
        return Optional.of(currentUser);
    }
}