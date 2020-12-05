package ir.streamdata.service;

import ir.streamdata.model.dto.TransactionDto;

public interface TransactionService {

    TransactionDto save(TransactionDto transactionDto);

}
