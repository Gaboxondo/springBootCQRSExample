package com.mashosoft.AccountCommand.application.commands;

import com.mashosoft.AccountCommand.application.events.AccountEventSourceHandler;
import com.mashosoft.AccountCommand.domain.aggregates.AccountAggregate;
import com.mashosoft.AccountCommand.domain.commands.CloseAccountCommandDTO;
import com.mashosoft.AccountCommand.domain.commands.DepositMoneyCommandDTO;
import com.mashosoft.AccountCommand.domain.commands.OpenAccountCommandDTO;
import com.mashosoft.AccountCommand.domain.commands.WithdrawMoneyCommandDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountCommandHandlerImpl implements AccountCommandHandler {

    private final AccountEventSourceHandler accountEventSourceHandler;

    @Override
    public AccountAggregate handle(OpenAccountCommandDTO openAccountCommandDTO) {
        AccountAggregate accountAggregate = new AccountAggregate( openAccountCommandDTO );
        accountEventSourceHandler.save( accountAggregate );
        return accountAggregate;
    }

    @Override
    public AccountAggregate handle(DepositMoneyCommandDTO depositMoneyCommandDTO) {
        AccountAggregate accountAggregate = accountEventSourceHandler.getById( depositMoneyCommandDTO.getId() );
        accountAggregate.depositMoney( depositMoneyCommandDTO.getAmount() );
        accountEventSourceHandler.save( accountAggregate );
        return accountAggregate;
    }

    @Override
    public AccountAggregate handle(WithdrawMoneyCommandDTO withdrawMoneyCommandDTO) {
        AccountAggregate accountAggregate = accountEventSourceHandler.getById( withdrawMoneyCommandDTO.getId() );
        accountAggregate.withdrawMoney( withdrawMoneyCommandDTO.getAmount() );
        accountEventSourceHandler.save( accountAggregate );
        return accountAggregate;
    }

    @Override
    public AccountAggregate handle(CloseAccountCommandDTO closeAccountCommandDTO) {
        AccountAggregate accountAggregate = accountEventSourceHandler.getById( closeAccountCommandDTO.getId() );
        accountAggregate.closeAccount();
        accountEventSourceHandler.save( accountAggregate );
        return accountAggregate;
    }
}
