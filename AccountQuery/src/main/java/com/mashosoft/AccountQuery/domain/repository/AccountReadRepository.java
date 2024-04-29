package com.mashosoft.AccountQuery.domain.repository;

import com.mashosoft.AccountQuery.domain.model.AccountRead;

public interface AccountReadRepository {

    public AccountRead getAccountReadFromDatabaseById(String id);
    public AccountRead save(AccountRead accountRead);

    public AccountRead delete(AccountRead accountRead);
}
