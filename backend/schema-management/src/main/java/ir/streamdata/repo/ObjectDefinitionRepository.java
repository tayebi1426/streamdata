package ir.streamdata.repo;

import ir.streamdata.model.entity.schemadefinition.ObjectDefinition;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectDefinitionRepository extends AbstractJpaRepository<ObjectDefinition,Integer> {
}
