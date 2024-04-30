package com.mashosoft.AccountQuery.application;

import com.mashosoft.AccountQuery.domain.events.AccountOpenedEvent;
import com.mashosoft.AccountQuery.domain.events.CloseAccountEvent;
import com.mashosoft.AccountQuery.domain.events.DepositMoneyEvent;
import com.mashosoft.AccountQuery.domain.events.WithdrawMoneyEvent;

public interface AccountEventsService {

    public void handleUpdateOfCommand(AccountOpenedEvent accountOpenedEvent);
    public void handleUpdateOfCommand(CloseAccountEvent closeAccountEvent);
    public void handleUpdateOfCommand(WithdrawMoneyEvent withdrawMoneyEvent);
    public void handleUpdateOfCommand(DepositMoneyEvent accountOpenedEvent);

    public void dropAccountTableAndPublishEventsForRepublish();
}
