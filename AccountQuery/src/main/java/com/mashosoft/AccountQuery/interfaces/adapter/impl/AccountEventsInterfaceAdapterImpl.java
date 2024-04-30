package com.mashosoft.AccountQuery.interfaces.adapter.impl;

import com.mashosoft.AccountQuery.application.AccountEventsService;
import com.mashosoft.AccountQuery.interfaces.adapter.AccountEventsInterfaceAdapter;
import com.mashosoft.AccountQuery.interfaces.adapter.impl.mapper.AccountEventsMapper;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.AccountOpenedEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.CloseAccountEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.DepositMoneyEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.WithdrawMoneyEventDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountEventsInterfaceAdapterImpl implements AccountEventsInterfaceAdapter {

    private final AccountEventsService accountEventsService;
    private final AccountEventsMapper accountEventsMapper;

    @Override
    public void handle(AccountOpenedEventDTO accountOpenedEventDTO) {
        accountEventsService.handleUpdateOfCommand( accountEventsMapper.fromInterfaceToDomain( accountOpenedEventDTO ) );
    }

    @Override
    public void handle(CloseAccountEventDTO closeAccountEventDTO) {
        accountEventsService.handleUpdateOfCommand( accountEventsMapper.fromInterfaceToDomain( closeAccountEventDTO ) );
    }

    @Override
    public void handle(DepositMoneyEventDTO depositMoneyEventDTO) {
        accountEventsService.handleUpdateOfCommand( accountEventsMapper.fromInterfaceToDomain( depositMoneyEventDTO ) );
    }

    @Override
    public void handle(WithdrawMoneyEventDTO withdrawMoneyEventDTO) {
        accountEventsService.handleUpdateOfCommand( accountEventsMapper.fromInterfaceToDomain( withdrawMoneyEventDTO ) );
    }
}
