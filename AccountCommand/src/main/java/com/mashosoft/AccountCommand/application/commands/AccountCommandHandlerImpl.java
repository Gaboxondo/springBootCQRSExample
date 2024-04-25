package com.mashosoft.AccountCommand.application.commands;

import com.mashosoft.AccountCommand.domain.events.store.AccountEventSourceHandler;
import com.mashosoft.AccountCommand.domain.aggregates.AccountAggregate;
import com.mashosoft.AccountCommand.domain.commands.CloseAccountCommand;
import com.mashosoft.AccountCommand.domain.commands.DepositMoneyCommand;
import com.mashosoft.AccountCommand.domain.commands.OpenAccountCommand;
import com.mashosoft.AccountCommand.domain.commands.WithdrawMoneyCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountCommandHandlerImpl implements AccountCommandHandler {

    private final AccountEventSourceHandler accountEventSourceHandler;

    @Override
    public AccountAggregate handle(OpenAccountCommand openAccountCommand) {
        AccountAggregate accountAggregate = new AccountAggregate( openAccountCommand );
        accountEventSourceHandler.save( accountAggregate );
        return accountAggregate;
    }

    @Override
    public AccountAggregate handle(DepositMoneyCommand depositMoneyCommand) {
        AccountAggregate accountAggregate = accountEventSourceHandler.getById( depositMoneyCommand.getId() );
        accountAggregate.depositMoney( depositMoneyCommand.getAmount() );
        accountEventSourceHandler.save( accountAggregate );
        return accountAggregate;
    }

    @Override
    public AccountAggregate handle(WithdrawMoneyCommand withdrawMoneyCommand) {
        AccountAggregate accountAggregate = accountEventSourceHandler.getById( withdrawMoneyCommand.getId() );
        accountAggregate.withdrawMoney( withdrawMoneyCommand.getAmount() );
        accountEventSourceHandler.save( accountAggregate );
        return accountAggregate;
    }

    @Override
    public AccountAggregate handle(CloseAccountCommand closeAccountCommand) {
        AccountAggregate accountAggregate = accountEventSourceHandler.getById( closeAccountCommand.getId() );
        accountAggregate.closeAccount();
        accountEventSourceHandler.save( accountAggregate );
        return accountAggregate;
    }
}
