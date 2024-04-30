package com.mashosoft.AccountQuery.application.impl;

import com.mashosoft.AccountQuery.application.AccountReadService;
import com.mashosoft.AccountQuery.domain.entity.AccountRead;
import com.mashosoft.AccountQuery.domain.events.RepublishEventsEvent;
import com.mashosoft.AccountQuery.domain.events.publisher.DbEventsPublisher;
import com.mashosoft.AccountQuery.domain.repository.AccountReadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountReadServiceImpl implements AccountReadService {

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
