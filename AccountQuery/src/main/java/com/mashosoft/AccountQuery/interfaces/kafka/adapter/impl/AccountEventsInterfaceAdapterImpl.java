package com.mashosoft.AccountQuery.interfaces.kafka.adapter.impl;

import com.mashosoft.AccountQuery.application.AccountCommandsUpdateService;
import com.mashosoft.AccountQuery.interfaces.kafka.adapter.AccountEventsInterfaceAdapter;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.AccountOpenedEventDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountEventsInterfaceAdapterImpl implements AccountEventsInterfaceAdapter {

    private final AccountCommandsUpdateService accountCommandsUpdateService;
    private final AccountEventsMapper accountEventsMapper;

    @Override
    public void handle(AccountOpenedEventDTO accountOpenedEventDTO) {
        accountCommandsUpdateService.handleUpdateOfCommand( accountEventsMapper.fromInterfaceToDomain( accountOpenedEventDTO ) );
    }
}
