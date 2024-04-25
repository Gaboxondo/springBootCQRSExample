package com.mashosoft.AccountCommand.interfaces.web.adapter;

import com.mashosoft.AccountCommand.interfaces.web.commandsDto.CloseAccountCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.DepositMoneyCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.OpenAccountCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.WithdrawMoneyCommandDTO;

public interface AccountCommandHandler {

    public void handle(OpenAccountCommandDTO openAccountCommandDTO);
    public void handle(DepositMoneyCommandDTO openAccountCommandDTO);
    public void handle(WithdrawMoneyCommandDTO openAccountCommandDTO);
    public void handle(CloseAccountCommandDTO openAccountCommandDTO);
}
