package com.mashosoft.AccountQuery.interfaces.kafka.adapter;

import com.mashosoft.AccountQuery.interfaces.kafka.dto.AccountOpenedEventDTO;
import com.mashosoft.AccountQuery.interfaces.web.dto.AccountReadDTO;

public interface AccountEventsInterfaceAdapter {

    public void handle(AccountOpenedEventDTO accountOpenedEventDTO);

}
