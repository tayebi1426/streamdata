package ir.streamdata.service.impl;

import ir.streamdata.mapper.EntityMapper;
import ir.streamdata.model.dto.ObjectDefinitionDto;
import ir.streamdata.model.dto.PropertyDefinitionDto;
import ir.streamdata.model.dto.datagrid.DataSourceRequest;
import ir.streamdata.model.dto.datagrid.DataSourceResponse;
import ir.streamdata.model.entity.schemadefinition.ObjectDefinition;
import ir.streamdata.model.entity.schemadefinition.PropertyDefinition;
import ir.streamdata.repo.ObjectDefinitionRepository;
import ir.streamdata.service.ObjectDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ObjectDefinitionServiceImpl implements ObjectDefinitionService, EntityMapper<ObjectDefinition, ObjectDefinitionDto> {

    private final ObjectDefinitionRepository objectDefinitionRepo;
    @Autowired
    private EntityMapper<PropertyDefinition, PropertyDefinitionDto> fieldDefinitionEntityMapper;

    public ObjectDefinitionServiceImpl(ObjectDefinitionRepository objectDefinitionRepo) {
        this.objectDefinitionRepo = objectDefinitionRepo;
    }

    @Transactional(readOnly = true)
    @Override
    public DataSourceResponse<ObjectDefinitionDto> search(DataSourceRequest dataSourceRequest) {
        List<ObjectDefinition> objectDefinitions = objectDefinitionRepo.findAll();
        return new DataSourceResponse<>(convertToDto(objectDefinitions));
    }

    private List<ObjectDefinitionDto> convertToDto(List<ObjectDefinition> objectDefinitions) {
        return objectDefinitions.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public ObjectDefinitionDto convertToDto(ObjectDefinition entity) {
        Set<PropertyDefinition> propertyDefinitions = entity.getFields();
        Set<PropertyDefinitionDto> propertyDefinitionDtoSet = propertyDefinitions.stream().map(fieldDefinitionEntityMapper::convertToDto).collect(Collectors.toSet());
        ObjectDefinitionDto dto = new ObjectDefinitionDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setFields(propertyDefinitionDtoSet);
        return dto;
    }
}
