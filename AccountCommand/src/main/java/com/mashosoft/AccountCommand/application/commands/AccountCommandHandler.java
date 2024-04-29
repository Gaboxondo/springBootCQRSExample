package com.mashosoft.AccountCommand.application.commands;

import com.mashosoft.AccountCommand.domain.aggregates.AccountAggregate;
import com.mashosoft.AccountCommand.domain.commands.CloseAccountCommand;
import com.mashosoft.AccountCommand.domain.commands.DepositMoneyCommand;
import com.mashosoft.AccountCommand.domain.commands.OpenAccountCommand;
import com.mashosoft.AccountCommand.domain.commands.WithdrawMoneyCommand;

public interface AccountCommandHandler {

    public AccountAggregate handle(OpenAccountCommand openAccountCommand);
    public AccountAggregate handle(DepositMoneyCommand depositMoneyCommand);
    public AccountAggregate handle(WithdrawMoneyCommand withdrawMoneyCommand);
    public AccountAggregate handle(CloseAccountCommand closeAccountCommand);

    void restoreDbRepublishingEvents();
}
