package com.mashosoft.AccountQuery.application.impl;

import com.mashosoft.AccountQuery.application.AccountCommandsUpdateService;
import com.mashosoft.AccountQuery.domain.model.AccountRead;
import com.mashosoft.AccountQuery.domain.model.events.AccountOpenedEvent;
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
            throw new IllegalArgumentException("Error, ya existe una cuenta con ese ID por lo que no se puede crear de nuevo");
            //Throw exception here because this is a mistake
        }

        AccountRead accountRead = new AccountRead(accountOpenedEvent);
        accountReadRepository.save( accountRead );

    }
}
