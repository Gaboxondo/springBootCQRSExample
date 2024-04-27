package com.mashosoft.AccountQuery.application;

import com.mashosoft.AccountQuery.domain.model.AccountRead;

public interface AcountReadService {

    public AccountRead getAccountById(String id);
}
