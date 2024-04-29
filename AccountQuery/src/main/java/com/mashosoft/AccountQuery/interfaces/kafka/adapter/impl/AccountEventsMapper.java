package com.mashosoft.AccountQuery.interfaces.kafka.adapter.impl;

import com.mashosoft.AccountQuery.application.AccountCommandsUpdateService;
import com.mashosoft.AccountQuery.domain.model.events.AccountOpenedEvent;
import com.mashosoft.AccountQuery.domain.model.events.CloseAccountEvent;
import com.mashosoft.AccountQuery.domain.model.events.DepositMoneyEvent;
import com.mashosoft.AccountQuery.domain.model.events.WithdrawMoneyEvent;
import com.mashosoft.AccountQuery.interfaces.kafka.adapter.AccountEventsInterfaceAdapter;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.AccountOpenedEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.CloseAccountEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.DepositMoneyEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.WithdrawMoneyEventDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AccountEventsMapper  {

    public AccountOpenedEvent fromInterfaceToDomain(AccountOpenedEventDTO accountOpenedEventDTO){
        return AccountOpenedEvent.builder()
            .version( accountOpenedEventDTO.getVersion() )
            .id( accountOpenedEventDTO.getId() )
            .accountHolder( accountOpenedEventDTO.getAccountHolder() )
            .creationDate( accountOpenedEventDTO.getCreationDate() )
            .openingBalance( accountOpenedEventDTO.getOpeningBalance() )
            .build();
    }

    public CloseAccountEvent fromInterfaceToDomain(CloseAccountEventDTO closeAccountEventDTO){
        return CloseAccountEvent.builder()
            .id( closeAccountEventDTO.getId() )
            .version( closeAccountEventDTO.getVersion() )
            .build();
    }

    public WithdrawMoneyEvent fromInterfaceToDomain(WithdrawMoneyEventDTO withdrawMoneyEventDTO){
        return WithdrawMoneyEvent.builder()
            .id( withdrawMoneyEventDTO.getId() )
            .version( withdrawMoneyEventDTO.getVersion() )
            .amount( withdrawMoneyEventDTO.getAmount() )
            .build();
    }

    public DepositMoneyEvent fromInterfaceToDomain(DepositMoneyEventDTO depositMoneyEventDTO){
        return DepositMoneyEvent.builder()
            .id( depositMoneyEventDTO.getId() )
            .version( depositMoneyEventDTO.getVersion() )
            .amount( depositMoneyEventDTO.getAmount() )
            .build();
    }
}
