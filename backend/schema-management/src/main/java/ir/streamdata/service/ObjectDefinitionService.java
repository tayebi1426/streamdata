package ir.streamdata.service;

import ir.streamdata.model.dto.datagrid.DataSourceRequest;
import ir.streamdata.model.dto.datagrid.DataSourceResponse;
import ir.streamdata.model.dto.ObjectDefinitionDto;

public interface ObjectDefinitionService {

    DataSourceResponse<ObjectDefinitionDto> search(DataSourceRequest dataSourceRequest);
}
