package ir.streamdata.service;

import ir.streamdata.dto.AccountDto;
import ir.streamdata.dto.datagrid.DataSourceResponse;

public interface AccountService {

    AccountDto createNew(AccountDto account);


    DataSourceResponse<AccountDto> getAccountList();
}
