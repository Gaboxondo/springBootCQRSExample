package com.mashosoft.AccountQuery.interfaces.adapter;

import com.mashosoft.AccountQuery.interfaces.kafka.dto.AccountUpdateEventDTO;

public interface AccountEventsInterfaceAdapter {

    public void handle(AccountUpdateEventDTO accountUpdateEventDTO);

}
