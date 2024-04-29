package com.mashosoft.AccountQuery.application;

import com.mashosoft.AccountQuery.domain.model.events.AccountOpenedEvent;
import com.mashosoft.AccountQuery.domain.model.events.CloseAccountEvent;
import com.mashosoft.AccountQuery.domain.model.events.DepositMoneyEvent;
import com.mashosoft.AccountQuery.domain.model.events.WithdrawMoneyEvent;

public interface AccountCommandsUpdateService {

    public void handleUpdateOfCommand(AccountOpenedEvent accountOpenedEvent);
    public void handleUpdateOfCommand(CloseAccountEvent closeAccountEvent);
    public void handleUpdateOfCommand(WithdrawMoneyEvent withdrawMoneyEvent);
    public void handleUpdateOfCommand(DepositMoneyEvent accountOpenedEvent);
}
