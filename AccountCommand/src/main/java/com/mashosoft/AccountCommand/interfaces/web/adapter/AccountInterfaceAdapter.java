package com.mashosoft.AccountCommand.interfaces.web.adapter;

import com.mashosoft.AccountCommand.interfaces.web.controller.dto.AccountDTO;
import com.mashosoft.AccountCommand.interfaces.web.controller.dto.DepositMoneyDTO;
import com.mashosoft.AccountCommand.interfaces.web.controller.dto.OpenAccountDTO;
import com.mashosoft.AccountCommand.interfaces.web.controller.dto.WithdrawMoneyDTO;

public interface AccountInterfaceAdapter {

    public AccountDTO createAccount(OpenAccountDTO openAccountDTO);
    public AccountDTO depositMoney(String id, DepositMoneyDTO depositMoneyDTO);
    public AccountDTO withdrawMoney(String id, WithdrawMoneyDTO openAccountCommandDTO);
    public AccountDTO closeAccount(String id);
}
