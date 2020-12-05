package ir.streamdata.model.entity.base;

import ir.streamdata.model.entity.AuditEntityListener;
import ir.streamdata.model.entity.security.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(AuditEntityListener.class)
public abstract class AuditEntity<T extends Number> extends BaseEntity<T> {

    private User createdBy;
    private User lastModifiedBy;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;

    @NotNull
    @ManyToOne
    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @NotNull
    @ManyToOne
    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @NotNull
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @NotNull
    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Transient
    public boolean isNew() {
        return getId() == null;
    }

}
