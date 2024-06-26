package com.mashosoft.AccountQuery.infrastructure.postgressdb.adapter;

import com.mashosoft.AccountQuery.domain.entity.AccountRead;
import com.mashosoft.AccountQuery.infrastructure.postgressdb.entity.AccountEntityJpa;
import org.springframework.stereotype.Component;

@Component
public class AccountDbMapper {

    public AccountRead fromDbToDomain(AccountEntityJpa accountEntityJpa){
        AccountRead accountRead = new AccountRead(accountEntityJpa.getId(),accountEntityJpa.getAccountHolder(),
            accountEntityJpa.getCreationDate(),accountEntityJpa.getBalance(),accountEntityJpa.getVersion());
        return accountRead;
    }

    public AccountEntityJpa fromDomainToDb(AccountRead accountRead){
        AccountEntityJpa accountEntityJpa = new AccountEntityJpa(accountRead.getId(),accountRead.getAccountHolder(),
            accountRead.getCreationDate(),accountRead.getBalance(),accountRead.getVersion());
        return accountEntityJpa;
    }
}
