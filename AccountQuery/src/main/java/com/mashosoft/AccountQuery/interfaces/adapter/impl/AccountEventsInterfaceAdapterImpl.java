package com.mashosoft.AccountQuery.interfaces.adapter.impl;

import com.mashosoft.AccountQuery.application.AccountEventsService;
import com.mashosoft.AccountQuery.domain.events.*;
import com.mashosoft.AccountQuery.interfaces.adapter.AccountEventsInterfaceAdapter;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.AccountUpdateEventDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountEventsInterfaceAdapterImpl implements AccountEventsInterfaceAdapter {

    private final AccountEventsService accountEventsService;

    @Override
    public void handle(AccountUpdateEventDTO accountUpdateEventDTO) {
        if(AccountEventTypes.ACCOUNT_CREATED.name().equals( accountUpdateEventDTO.getOperation() )){
            AccountOpenedEvent accountOpenedEvent = AccountOpenedEvent.builder()
                .version( accountUpdateEventDTO.getVersion() )
                .id( accountUpdateEventDTO.getId() )
                .accountHolder( accountUpdateEventDTO.getAccountHolder() )
                .creationDate( accountUpdateEventDTO.getCreationDate() )
                .openingBalance( accountUpdateEventDTO.getOpeningBalance() )
                .build();
            accountEventsService.handleUpdateOfCommand( accountOpenedEvent );
        } else if(AccountEventTypes.ACCOUNT_CLOSED.name().equals( accountUpdateEventDTO.getOperation() )){
            CloseAccountEvent closeAccountEvent = CloseAccountEvent.builder()
                .id( accountUpdateEventDTO.getId() )
                .version( accountUpdateEventDTO.getVersion() )
                .build();
            accountEventsService.handleUpdateOfCommand( closeAccountEvent );
        } else if(AccountEventTypes.DEPOSIT_MONEY.name().equals( accountUpdateEventDTO.getOperation() )){
            DepositMoneyEvent depositMoneyEvent = DepositMoneyEvent.builder()
                .id( accountUpdateEventDTO.getId() )
                .version( accountUpdateEventDTO.getVersion() )
                .amount( accountUpdateEventDTO.getAmount() )
                .build();
            accountEventsService.handleUpdateOfCommand( depositMoneyEvent );
        }  else if(AccountEventTypes.WITHDRAW_MONEY.name().equals( accountUpdateEventDTO.getOperation() )){
            WithdrawMoneyEvent withdrawMoneyEvent = WithdrawMoneyEvent.builder()
                .id( accountUpdateEventDTO.getId() )
                .version( accountUpdateEventDTO.getVersion() )
                .amount( accountUpdateEventDTO.getAmount() )
                .build();
            accountEventsService.handleUpdateOfCommand( withdrawMoneyEvent );
        }

    }
}
