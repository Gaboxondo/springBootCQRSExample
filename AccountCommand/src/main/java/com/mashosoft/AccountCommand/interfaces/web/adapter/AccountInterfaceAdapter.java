package com.mashosoft.AccountCommand.interfaces.web.adapter;

import com.mashosoft.AccountCommand.domain.commands.CloseAccountCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.AccountDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.DepositMoneyDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.OpenAccountDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.WithdrawMoneyDTO;

public interface AccountInterfaceAdapter {

    public AccountDTO createAccount(OpenAccountDTO openAccountDTO);
    public AccountDTO depositMoney(String id, DepositMoneyDTO depositMoneyDTO);
    public AccountDTO withdrawMoney(String id, WithdrawMoneyDTO openAccountCommandDTO);
    public AccountDTO closeAccount(String id);
}
