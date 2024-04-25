package com.mashosoft.AccountCommand.domain.events.store;

import com.mashosoft.AccountCommand.eventFrameworkCore.events.BaseEvent;

import java.util.List;

public interface AccountEventStore {

    void saveEvents(String aggregateId, Iterable<BaseEvent> events,Integer expectedVersion);
    List<BaseEvent> getEvents(String aggregateId);
}
