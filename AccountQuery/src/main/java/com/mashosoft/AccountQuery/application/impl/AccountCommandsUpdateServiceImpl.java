package com.mashosoft.AccountQuery.application.impl;

import com.mashosoft.AccountQuery.application.AccountCommandsUpdateService;
import com.mashosoft.AccountQuery.domain.model.AccountRead;
import com.mashosoft.AccountQuery.domain.model.events.AccountOpenedEvent;
import com.mashosoft.AccountQuery.domain.model.events.CloseAccountEvent;
import com.mashosoft.AccountQuery.domain.model.events.DepositMoneyEvent;
import com.mashosoft.AccountQuery.domain.model.events.WithdrawMoneyEvent;
import com.mashosoft.AccountQuery.domain.repository.AccountReadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountCommandsUpdateServiceImpl implements AccountCommandsUpdateService {

    private final AccountReadRepository accountReadRepository;

    @Override
    public void handleUpdateOfCommand(AccountOpenedEvent accountOpenedEvent) {
        AccountRead alreadyExistingAccount = accountReadRepository.getAccountReadFromDatabaseById(accountOpenedEvent.getId());
        if(alreadyExistingAccount != null){
            throw new IllegalArgumentException("Error, there is already an account with such ID");
        }

        AccountRead accountRead = new AccountRead(accountOpenedEvent);
        accountReadRepository.save( accountRead );

    }

    @Override
    public void handleUpdateOfCommand(CloseAccountEvent closeAccountEvent) {
        AccountRead alreadyExistingAccount = accountReadRepository.getAccountReadFromDatabaseById(closeAccountEvent.getId());
        if(alreadyExistingAccount == null){
            throw new IllegalArgumentException("Error, it does not exists an account with such id");
        }

        accountReadRepository.delete( alreadyExistingAccount );
    }

    @Override
    public void handleUpdateOfCommand(WithdrawMoneyEvent withdrawMoneyEvent) {
        AccountRead alreadyExistingAccount = accountReadRepository.getAccountReadFromDatabaseById(withdrawMoneyEvent.getId());
        if(alreadyExistingAccount == null){
            throw new IllegalArgumentException("Error, it does not exists an account with such id");
        }
        alreadyExistingAccount.applyChanges( withdrawMoneyEvent );
        accountReadRepository.save( alreadyExistingAccount );
    }

    @Override
    public void handleUpdateOfCommand(DepositMoneyEvent depositMoneyEvent) {
        AccountRead alreadyExistingAccount = accountReadRepository.getAccountReadFromDatabaseById(depositMoneyEvent.getId());
        if(alreadyExistingAccount == null){
            throw new IllegalArgumentException("Error, it does not exists an account with such id");
        }
        alreadyExistingAccount.applyChanges( depositMoneyEvent );
        accountReadRepository.save( alreadyExistingAccount );
    }
}
