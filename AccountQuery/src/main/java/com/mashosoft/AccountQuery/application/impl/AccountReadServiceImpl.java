package com.mashosoft.AccountQuery.application.impl;

import com.mashosoft.AccountQuery.application.AcountReadService;
import com.mashosoft.AccountQuery.domain.model.AccountRead;
import com.mashosoft.AccountQuery.domain.repository.AccountReadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountReadServiceImpl implements AcountReadService {

    private final AccountReadRepository accountReadRepository;

    @Override
    public AccountRead getAccountById(String id) {
        AccountRead accountRead = accountReadRepository.getAccountReadFromDatabaseById( id );
        if(accountRead == null){
            throw new IllegalArgumentException( "No Account found with this ID" );
        }
        return accountRead;
    }
}
