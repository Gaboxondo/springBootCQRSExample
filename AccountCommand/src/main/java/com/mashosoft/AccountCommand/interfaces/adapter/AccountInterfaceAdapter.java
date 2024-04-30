package com.mashosoft.AccountCommand.interfaces.adapter;

import com.mashosoft.AccountCommand.interfaces.web.dto.AccountDTO;
import com.mashosoft.AccountCommand.interfaces.web.dto.DepositMoneyDTO;
import com.mashosoft.AccountCommand.interfaces.web.dto.OpenAccountDTO;
import com.mashosoft.AccountCommand.interfaces.web.dto.WithdrawMoneyDTO;

public interface AccountInterfaceAdapter {

    public AccountDTO createAccount(OpenAccountDTO openAccountDTO);
    public AccountDTO depositMoney(String id, DepositMoneyDTO depositMoneyDTO);
    public AccountDTO withdrawMoney(String id, WithdrawMoneyDTO openAccountCommandDTO);
    public AccountDTO closeAccount(String id);

    public void restoreDbRepublishingEvents();
}
