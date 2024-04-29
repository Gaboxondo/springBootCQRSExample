package com.mashosoft.AccountCommand.interfaces.web.adapter.impl;

import com.mashosoft.AccountCommand.application.commands.AccountCommandHandler;
import com.mashosoft.AccountCommand.domain.aggregates.AccountAggregate;
import com.mashosoft.AccountCommand.domain.commands.CloseAccountCommand;
import com.mashosoft.AccountCommand.domain.commands.DepositMoneyCommand;
import com.mashosoft.AccountCommand.domain.commands.OpenAccountCommand;
import com.mashosoft.AccountCommand.domain.commands.WithdrawMoneyCommand;
import com.mashosoft.AccountCommand.interfaces.web.adapter.AccountInterfaceAdapter;
import com.mashosoft.AccountCommand.interfaces.web.adapter.mapper.AccountInterfaceMapper;
import com.mashosoft.AccountCommand.interfaces.web.controller.dto.AccountDTO;
import com.mashosoft.AccountCommand.interfaces.web.controller.dto.DepositMoneyDTO;
import com.mashosoft.AccountCommand.interfaces.web.controller.dto.OpenAccountDTO;
import com.mashosoft.AccountCommand.interfaces.web.controller.dto.WithdrawMoneyDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountInterfaceAdapterImpl implements AccountInterfaceAdapter {

    private final AccountInterfaceMapper accountInterfaceMapper;
    private final AccountCommandHandler accountCommandHandler;

    @Override
    public AccountDTO createAccount(OpenAccountDTO openAccountDTO) {
        OpenAccountCommand openAccountCommand = new OpenAccountCommand(openAccountDTO.getAccountHolder(),openAccountDTO.getOpeningBalance());
        AccountAggregate accountAggregate = accountCommandHandler.handle( openAccountCommand );
        return accountInterfaceMapper.fromDomainToDTO( accountAggregate );
    }

    @Override
    public AccountDTO depositMoney(String id,DepositMoneyDTO depositMoneyDTO) {
        DepositMoneyCommand depositMoneyCommand = DepositMoneyCommand.builder().id( id ).amount(
            depositMoneyDTO.getAmount() ).build();
        AccountAggregate accountAggregate = accountCommandHandler.handle( depositMoneyCommand );
        return accountInterfaceMapper.fromDomainToDTO( accountAggregate );
    }

    @Override
    public AccountDTO withdrawMoney(String id, WithdrawMoneyDTO withdrawMoneyDTO) {
        WithdrawMoneyCommand withdrawMoneyCommand = WithdrawMoneyCommand.builder().id( id ).amount(
            withdrawMoneyDTO.getAmount() ).build();
        AccountAggregate accountAggregate = accountCommandHandler.handle( withdrawMoneyCommand );
        return accountInterfaceMapper.fromDomainToDTO( accountAggregate );
    }

    @Override
    public AccountDTO closeAccount(String id) {
        CloseAccountCommand closeAccountCommand = new CloseAccountCommand( id );
        AccountAggregate accountAggregate = accountCommandHandler.handle( closeAccountCommand );
        return accountInterfaceMapper.fromDomainToDTO( accountAggregate );
    }

    @Override
    public void restoreDbRepublishingEvents() {
        accountCommandHandler.restoreDbRepublishingEvents();
    }
}
