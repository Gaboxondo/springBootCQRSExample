package com.mashosoft.AccountCommand.interfaces.adapter.mapper;

import com.mashosoft.AccountCommand.domain.aggregates.AccountAggregate;
import com.mashosoft.AccountCommand.interfaces.web.dto.AccountDTO;
import org.springframework.stereotype.Component;

@Component
public class AccountInterfaceMapper {

    public AccountDTO fromDomainToDTO(AccountAggregate accountAggregate){
        return new AccountDTO( accountAggregate.getId(), accountAggregate.getActive(),accountAggregate.getBalance(),
            accountAggregate.getAccountHolder(), accountAggregate.getVersion() );
    }
}
