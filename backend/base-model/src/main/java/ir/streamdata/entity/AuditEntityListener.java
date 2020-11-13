package ir.streamdata.entity;

import ir.streamdata.dto.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;

public class AuditEntityListener<E extends AuditEntity<Number>> {

    @PrePersist
    public void touchForCreate(E entity) {
        entity.setCreatedBy(getCurrentUser());
        entity.setCreatedDate(LocalDate.now());
        touchForUpdate(entity);
    }

    @PreUpdate
    public void touchForUpdate(E entity) {
        entity.setLastModifiedBy(getCurrentUser());
        entity.setLastModifiedDate(LocalDate.now());
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new IllegalStateException("anonymous user!");
        }
        CustomUserDetails principal = (CustomUserDetails)
                authentication.getPrincipal();
        return new User(principal.getId());
    }
}
