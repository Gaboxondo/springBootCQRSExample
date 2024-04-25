package com.mashosoft.AccountCommand.application.events;

import com.mashosoft.AccountCommand.domain.aggregates.AccountAggregate;

public interface AccountEventSourceHandler {
    void save(AccountAggregate accountAggregate);
    AccountAggregate getById(String id);

}