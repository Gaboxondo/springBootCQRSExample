package com.mashosoft.AccountQuery.interfaces.kafka.adapter.impl;

import com.mashosoft.AccountQuery.application.AccountCommandsUpdateService;
import com.mashosoft.AccountQuery.interfaces.kafka.adapter.AccountEventsInterfaceAdapter;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.AccountOpenedEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.CloseAccountEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.DepositMoneyEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.WithdrawMoneyEventDTO;
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

    @Override
    public void handle(CloseAccountEventDTO closeAccountEventDTO) {
        accountCommandsUpdateService.handleUpdateOfCommand( accountEventsMapper.fromInterfaceToDomain( closeAccountEventDTO ) );
    }

    @Override
    public void handle(DepositMoneyEventDTO depositMoneyEventDTO) {
        accountCommandsUpdateService.handleUpdateOfCommand( accountEventsMapper.fromInterfaceToDomain( depositMoneyEventDTO ) );
    }

    @Override
    public void handle(WithdrawMoneyEventDTO withdrawMoneyEventDTO) {
        accountCommandsUpdateService.handleUpdateOfCommand( accountEventsMapper.fromInterfaceToDomain( withdrawMoneyEventDTO ) );
    }
}
