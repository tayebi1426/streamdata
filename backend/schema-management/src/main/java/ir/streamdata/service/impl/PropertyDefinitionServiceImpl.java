package ir.streamdata.service.impl;

import ir.streamdata.model.entity.schemadefinition.PropertyDefinition;
import ir.streamdata.mapper.EntityMapper;
import ir.streamdata.model.dto.PropertyDefinitionDto;
import ir.streamdata.service.PropertyDefinitionService;
import org.springframework.stereotype.Service;

@Service
public class PropertyDefinitionServiceImpl implements PropertyDefinitionService, EntityMapper<PropertyDefinition, PropertyDefinitionDto> {

    @Override
    public PropertyDefinitionDto convertToDto(PropertyDefinition entity) {
        PropertyDefinitionDto dto = new PropertyDefinitionDto();
        dto.setId(entity.getId());
        return dto;
    }
}
