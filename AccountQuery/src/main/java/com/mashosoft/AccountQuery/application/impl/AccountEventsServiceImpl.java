package com.mashosoft.AccountQuery.application.impl;

import com.mashosoft.AccountQuery.application.AccountEventsService;
import com.mashosoft.AccountQuery.domain.entity.AccountRead;
import com.mashosoft.AccountQuery.domain.events.*;
import com.mashosoft.AccountQuery.domain.events.publisher.DbEventsPublisher;
import com.mashosoft.AccountQuery.domain.repository.AccountReadRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class AccountEventsServiceImpl implements AccountEventsService {

    private final AccountReadRepository accountReadRepository;
    private final DbEventsPublisher dbEventsPublisher;

    @Override
    public void handleUpdateOfCommand(AccountOpenedEvent accountOpenedEvent) {
        AccountRead alreadyExistingAccount = accountReadRepository.getAccountReadFromDatabaseById(accountOpenedEvent.getId());
        if(alreadyExistingAccount != null){
            log.error( "The event received {}, with id {} can not create an account because there is already one",
                accountOpenedEvent.getClass().getSimpleName(),accountOpenedEvent.getId());
            throw new IllegalArgumentException("Error, there is already an account with such ID");
        }

        AccountRead accountRead = new AccountRead(accountOpenedEvent);
        accountReadRepository.save( accountRead );

    }

    @Override
    public void handleUpdateOfCommand(CloseAccountEvent closeAccountEvent) {
        AccountRead alreadyExistingAccount = accountReadRepository.getAccountReadFromDatabaseById(closeAccountEvent.getId());
        if(alreadyExistingAccount == null){
            log.error( "The event received {}, with id {} can not update the account because there is not account with such Id",
                closeAccountEvent.getClass().getSimpleName(),closeAccountEvent.getId());
            throw new IllegalArgumentException("Error, it does not exists an account with such id");
        }

        accountReadRepository.delete( alreadyExistingAccount );
    }

    @Override
    public void handleUpdateOfCommand(WithdrawMoneyEvent withdrawMoneyEvent) {
        AccountRead alreadyExistingAccount = accountReadRepository.getAccountReadFromDatabaseById(withdrawMoneyEvent.getId());
        if(alreadyExistingAccount == null){
            log.error( "The event received {}, with id {} can not update the account because there is not account with such Id",
                withdrawMoneyEvent.getClass().getSimpleName(),withdrawMoneyEvent.getId());
            throw new IllegalArgumentException("Error, it does not exists an account with such id");
        }
        alreadyExistingAccount.applyChanges( withdrawMoneyEvent );
        accountReadRepository.save( alreadyExistingAccount );
    }

    @Override
    public void handleUpdateOfCommand(DepositMoneyEvent depositMoneyEvent) {
        AccountRead alreadyExistingAccount = accountReadRepository.getAccountReadFromDatabaseById(depositMoneyEvent.getId());
        if(alreadyExistingAccount == null){
            log.error( "The event received {}, with id {} can not update the account because there is not account with such Id",
                depositMoneyEvent.getClass().getSimpleName(),depositMoneyEvent.getId());
            throw new IllegalArgumentException("Error, it does not exists an account with such id");
        }
        alreadyExistingAccount.applyChanges( depositMoneyEvent );
        accountReadRepository.save( alreadyExistingAccount );
    }

    public void dropAccountTableAndPublishEventsForRepublish(){
        accountReadRepository.dropTable();
        dbEventsPublisher.publishReconstructDatabaseEvent( RepublishEventsEvent.builder().id( UUID.randomUUID().toString() ).build() );
    }
}
