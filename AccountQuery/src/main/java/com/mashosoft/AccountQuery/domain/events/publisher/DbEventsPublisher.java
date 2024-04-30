package com.mashosoft.AccountQuery.domain.events.publisher;

import com.mashosoft.AccountQuery.eventFrameworkCore.events.BaseEvent;

public interface DbEventsPublisher {

    public void publishReconstructDatabaseEvent(BaseEvent baseEvent);
}
