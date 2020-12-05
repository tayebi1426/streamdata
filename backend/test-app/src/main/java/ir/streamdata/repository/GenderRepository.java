package ir.streamdata.repository;

import ir.streamdata.model.entity.base.Gender;
import ir.streamdata.repo.AbstractJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface GenderRepository extends AbstractJpaRepository<Gender,Byte> {
}
