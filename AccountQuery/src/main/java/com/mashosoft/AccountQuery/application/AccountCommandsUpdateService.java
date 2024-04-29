package com.mashosoft.AccountQuery.application;

import com.mashosoft.AccountQuery.domain.model.events.AccountOpenedEvent;

public interface AccountCommandsUpdateService {

    public void handleUpdateOfCommand(AccountOpenedEvent accountOpenedEvent);
}
