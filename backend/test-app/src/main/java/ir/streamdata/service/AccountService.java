package ir.streamdata.service;

import ir.streamdata.model.dto.AccountDto;
import ir.streamdata.model.dto.datagrid.DataSourceResponse;

public interface AccountService {

    AccountDto createNew(AccountDto account);


    DataSourceResponse<AccountDto> getAccountList();
}
