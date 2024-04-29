package com.mashosoft.AccountQuery.interfaces.kafka.adapter.impl;

import com.mashosoft.AccountQuery.application.AccountCommandsUpdateService;
import com.mashosoft.AccountQuery.domain.model.events.AccountOpenedEvent;
import com.mashosoft.AccountQuery.interfaces.kafka.adapter.AccountEventsInterfaceAdapter;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.AccountOpenedEventDTO;
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
}
