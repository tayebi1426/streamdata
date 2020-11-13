package ir.streamdata.service;

import ir.streamdata.dto.TransactionDto;

public interface TransactionService {

    TransactionDto save(TransactionDto transactionDto);

}
