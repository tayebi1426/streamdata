package ir.streamdata.service.impl;

import ir.streamdata.dto.AccountDto;
import ir.streamdata.dto.datagrid.DataSourceResponse;
import ir.streamdata.entity.Account;
import ir.streamdata.repository.AccountRepo;
import ir.streamdata.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    @Transactional
    public AccountDto createNew(AccountDto accountDto) {
        Account newAccount = new Account(accountDto);
        return createNew(newAccount);
    }

    @Override
    @Transactional(readOnly = true)
    public DataSourceResponse<AccountDto> getAccountList() {
        List<Account> accountList = accountRepo.findAll();
        List<AccountDto> accountDtoList = accountList.stream().map(AccountDto::new).collect(Collectors.toList());
        return new DataSourceResponse<AccountDto>(accountDtoList.size(), accountDtoList);
    }

    @Transactional
    public AccountDto createNew(Account account) {
        return null;
    }

}
