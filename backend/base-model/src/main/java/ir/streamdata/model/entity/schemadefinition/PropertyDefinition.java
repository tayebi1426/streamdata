package ir.streamdata.model.entity.schemadefinition;

import ir.streamdata.model.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * author: hadi tayebi
 * date: 12/03/2020
 */
@Entity
public class PropertyDefinition extends BaseEntity<Integer> {

    private String name;
    private String title;
    private PrimitiveDataType dataType;
    private ObjectDefinition objectDefinition;

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

    @ManyToOne
    public PrimitiveDataType getDataType() {
        return dataType;
    }

    public void setDataType(PrimitiveDataType dataType) {
        this.dataType = dataType;
    }

    @ManyToOne
    public ObjectDefinition getObjectDefinition() {
        return objectDefinition;
    }

    public void setObjectDefinition(ObjectDefinition objectDefinition) {
        this.objectDefinition = objectDefinition;
    }
}
