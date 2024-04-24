package com.mashosoft.AccountCommand.domain.commandsHandlers.impl;

import com.mashosoft.AccountCommand.domain.commandsHandlers.AccountCommandHandler;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.CloseAccountCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.DepositMoneyCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.OpenAccountCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.WithdrawMoneyCommandDTO;

public class AccountCommandHandlerImpl implements AccountCommandHandler {

    @Override
    public void handle(OpenAccountCommandDTO commandDTO) {

    }

    @Override
    public void handle(DepositMoneyCommandDTO commandDTO) {

    }

    @Override
    public void handle(WithdrawMoneyCommandDTO commandDTO) {

    }

    @Override
    public void handle(CloseAccountCommandDTO commandDTO) {

    }
}
