package ir.streamdata.api;

import ir.streamdata.model.dto.ObjectDefinitionDto;
import ir.streamdata.model.dto.datagrid.DataSourceRequest;
import ir.streamdata.model.dto.datagrid.DataSourceResponse;
import ir.streamdata.service.ObjectDefinitionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objectDefinition")
public class ObjectDefinitionController {

    private ObjectDefinitionService objectDefinitionService;

    public ObjectDefinitionController(ObjectDefinitionService objectDefinitionService) {
        this.objectDefinitionService = objectDefinitionService;
    }

    @PostMapping("/search")
    public DataSourceResponse<ObjectDefinitionDto> search(@RequestBody DataSourceRequest dataSourceRequest) {
        return objectDefinitionService.search(dataSourceRequest);
    }
}
