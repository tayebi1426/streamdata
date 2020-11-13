package ir.streamdata.repository;

import ir.streamdata.entity.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface AccountRepo extends AbstractJpaRepository<Account, Integer> {

}
