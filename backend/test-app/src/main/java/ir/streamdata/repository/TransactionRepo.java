package ir.streamdata.repository;


import ir.streamdata.entity.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface TransactionRepo extends AbstractJpaRepository<Transaction, Integer> {

}
