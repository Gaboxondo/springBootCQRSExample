package com.mashosoft.AccountCommand.domain.commandsHandlers;

import com.mashosoft.AccountCommand.interfaces.web.commandsDto.CloseAccountCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.DepositMoneyCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.OpenAccountCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.WithdrawMoneyCommandDTO;

public interface AccountCommandHandler {
    void handle(OpenAccountCommandDTO commandDTO);
    void handle(DepositMoneyCommandDTO commandDTO);
    void handle(WithdrawMoneyCommandDTO commandDTO);
    void handle(CloseAccountCommandDTO commandDTO);
}
