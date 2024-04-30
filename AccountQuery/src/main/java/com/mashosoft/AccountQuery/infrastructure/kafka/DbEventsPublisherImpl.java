package com.mashosoft.AccountQuery.infrastructure.kafka;

import com.mashosoft.AccountQuery.domain.events.publisher.DbEventsPublisher;
import com.mashosoft.AccountQuery.eventFrameworkCore.events.BaseEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DbEventsPublisherImpl implements DbEventsPublisher {

    private final KafkaEventProducer kafkaEventProducer;

    @Override
    public void publishReconstructDatabaseEvent(BaseEvent baseEvent) {
        kafkaEventProducer.produceKafkaEvent( baseEvent.getClass().getSimpleName(),baseEvent );
    }

}
