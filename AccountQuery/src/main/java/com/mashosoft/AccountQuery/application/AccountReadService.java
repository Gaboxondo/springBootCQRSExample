package com.mashosoft.AccountQuery.application;

import com.mashosoft.AccountQuery.domain.entity.AccountRead;

public interface AccountReadService {

    public AccountRead getAccountById(String id);
}
