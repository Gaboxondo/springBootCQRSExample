package com.mashosoft.AccountQuery.interfaces.adapter.impl;

import com.mashosoft.AccountQuery.application.AccountEventsService;
import com.mashosoft.AccountQuery.interfaces.adapter.DatabaseInterfaceAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DatabaseInterfaceAdapterImpl implements DatabaseInterfaceAdapter {

    private final AccountEventsService accountEventsService;

    public void reconstructDb(){
        accountEventsService.dropAccountTableAndPublishEventsForRepublish();
    }

}
