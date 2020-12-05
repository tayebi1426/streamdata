package ir.streamdata.model.dto;

import java.util.Set;

public class ObjectDefinitionDto extends BaseDto<Integer> {

    private String name;
    private Set<PropertyDefinitionDto> fields;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PropertyDefinitionDto> getFields() {
        return fields;
    }

    public void setFields(Set<PropertyDefinitionDto> fields) {
        this.fields = fields;
    }
}
