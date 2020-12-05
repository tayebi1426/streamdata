package ir.streamdata.model.entity.schemadefinition;

import ir.streamdata.model.entity.base.AuditEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class ObjectDefinition extends AuditEntity<Integer> {

    private String name;
    private String title;
    private Set<PropertyDefinition> fields;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany(mappedBy = "objectDefinition")
    public Set<PropertyDefinition> getFields() {
        return fields;
    }

    public void setFields(Set<PropertyDefinition> fields) {
        this.fields = fields;
    }
}
