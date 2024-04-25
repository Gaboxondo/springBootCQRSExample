package com.mashosoft.AccountCommand.domain.events.store;

import com.mashosoft.AccountCommand.domain.aggregates.AccountAggregate;

public interface AccountEventSourceHandler {
    void save(AccountAggregate accountAggregate);
    AccountAggregate getById(String id);

}
