package ir.streamdata.service.impl;

import ir.streamdata.dto.TransactionDto;
import ir.streamdata.entity.Account;
import ir.streamdata.entity.Transaction;
import ir.streamdata.entity.TransactionType;
import ir.streamdata.repository.TransactionRepo;
import ir.streamdata.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    @Override
    @Transactional
    public TransactionDto save(TransactionDto transactionDto) {
        Transaction transaction = transactionRepo.save(convertDtoToEntity(transactionDto));
        return new TransactionDto(transaction.getId());
    }

    private Transaction convertDtoToEntity(TransactionDto dto) {
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(dto.getTransactionDate());
        transaction.setTransactionAmount(dto.getTransactionAmount());
        transaction.setDescription(dto.getDescription());
        transaction.setAccount(new Account(dto.getAccountId()));
        transaction.setTransactionType(new TransactionType(dto.getTransactionTypeId()));
        return transaction;
    }
}
