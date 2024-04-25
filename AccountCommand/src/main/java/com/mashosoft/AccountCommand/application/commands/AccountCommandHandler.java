package com.mashosoft.AccountCommand.application.commands;

import com.mashosoft.AccountCommand.domain.aggregates.AccountAggregate;
import com.mashosoft.AccountCommand.domain.commands.CloseAccountCommandDTO;
import com.mashosoft.AccountCommand.domain.commands.DepositMoneyCommandDTO;
import com.mashosoft.AccountCommand.domain.commands.OpenAccountCommandDTO;
import com.mashosoft.AccountCommand.domain.commands.WithdrawMoneyCommandDTO;

public interface AccountCommandHandler {

    public AccountAggregate handle(OpenAccountCommandDTO openAccountCommandDTO);
    public AccountAggregate handle(DepositMoneyCommandDTO depositMoneyCommandDTO);
    public AccountAggregate handle(WithdrawMoneyCommandDTO withdrawMoneyCommandDTO);
    public AccountAggregate handle(CloseAccountCommandDTO closeAccountCommandDTO);
}
