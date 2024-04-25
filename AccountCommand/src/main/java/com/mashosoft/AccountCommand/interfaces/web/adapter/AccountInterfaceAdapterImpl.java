package com.mashosoft.AccountCommand.interfaces.web.adapter;

import com.mashosoft.AccountCommand.application.commands.AccountCommandHandler;
import com.mashosoft.AccountCommand.application.events.AccountEventSourceHandler;
import com.mashosoft.AccountCommand.domain.aggregates.AccountAggregate;
import com.mashosoft.AccountCommand.domain.commands.CloseAccountCommandDTO;
import com.mashosoft.AccountCommand.domain.commands.DepositMoneyCommandDTO;
import com.mashosoft.AccountCommand.domain.commands.OpenAccountCommandDTO;
import com.mashosoft.AccountCommand.domain.commands.WithdrawMoneyCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.AccountDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.DepositMoneyDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.OpenAccountDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.WithdrawMoneyDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountInterfaceAdapterImpl implements AccountInterfaceAdapter {

    private final AccountEventSourceHandler accountEventSourceHandler;
    private final AccountCommandHandler accountCommandHandler;

    @Override
    public AccountDTO createAccount(OpenAccountDTO openAccountDTO) {
        OpenAccountCommandDTO openAccountCommandDTO = new OpenAccountCommandDTO(openAccountDTO.getAccountHolder(),openAccountDTO.getOpeningBalance());
        AccountAggregate accountAggregate = accountCommandHandler.handle( openAccountCommandDTO );
        //proper mapper and so on
        return new AccountDTO( accountAggregate.getId(), accountAggregate.getActive(),accountAggregate.getBalance(), accountAggregate.getAccountHolder() );
    }

    @Override
    public AccountDTO depositMoney(String id,DepositMoneyDTO depositMoneyDTO) {
        DepositMoneyCommandDTO depositMoneyCommandDTO = DepositMoneyCommandDTO.builder().id( id ).amount(
            depositMoneyDTO.getAmount() ).build();
        AccountAggregate accountAggregate = accountCommandHandler.handle( depositMoneyCommandDTO );
        return new AccountDTO( accountAggregate.getId(), accountAggregate.getActive(),accountAggregate.getBalance(), accountAggregate.getAccountHolder() );
    }

    @Override
    public AccountDTO withdrawMoney(String id, WithdrawMoneyDTO withdrawMoneyDTO) {
        WithdrawMoneyCommandDTO withdrawMoneyCommandDTO = WithdrawMoneyCommandDTO.builder().id( id ).amount(
            withdrawMoneyDTO.getAmount() ).build();
        AccountAggregate accountAggregate = accountCommandHandler.handle( withdrawMoneyCommandDTO );
        return new AccountDTO( accountAggregate.getId(), accountAggregate.getActive(),accountAggregate.getBalance(), accountAggregate.getAccountHolder() );
    }

    @Override
    public AccountDTO closeAccount(String id) {
        CloseAccountCommandDTO closeAccountCommandDTO = new CloseAccountCommandDTO( id );
        AccountAggregate accountAggregate = accountCommandHandler.handle( closeAccountCommandDTO );
        return new AccountDTO( accountAggregate.getId(), accountAggregate.getActive(),accountAggregate.getBalance(), accountAggregate.getAccountHolder() );
    }
}
