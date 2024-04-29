package com.mashosoft.AccountCommand.domain.events.store;

import com.mashosoft.AccountCommand.domain.aggregates.AccountAggregate;

import java.util.List;

public interface AccountEventSourceHandler {
    void save(AccountAggregate accountAggregate);
    AccountAggregate getById(String id);

    void restoreDbRepublishingEvents();
}
