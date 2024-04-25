package com.mashosoft.AccountCommand.application.events;

import com.mashosoft.AccountCommand.domain.aggregates.AccountAggregate;
import com.mashosoft.AccountCommand.domain.events.store.AccountEventStore;
import com.mashosoft.AccountCommand.eventFrameworkCore.events.BaseEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountEventSourceHandlerImpl implements AccountEventSourceHandler{

    private final AccountEventStore accountEventStore;

    @Override
    public void save(AccountAggregate accountAggregate) {
        accountEventStore.saveEvents( accountAggregate.getId(),
            accountAggregate.getUncommitedEventChanges(), accountAggregate.getVersion());
        accountAggregate.clearNewEventChanges();
    }

    @Override
    public AccountAggregate getById(String id) {
        AccountAggregate accountAggregate = new AccountAggregate(  );
        List<BaseEvent> events = accountEventStore.getEvents( id );
        if(events != null && !events.isEmpty()){
            accountAggregate.reconstructFromEvents( events );
        }

        return accountAggregate;
    }
}
