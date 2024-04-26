package com.mashosoft.AccountCommand.infrastructure;

import com.mashosoft.AccountCommand.domain.aggregates.AccountAggregate;
import com.mashosoft.AccountCommand.eventFrameworkCore.events.BaseEvent;
import com.mashosoft.AccountCommand.domain.events.store.AccountEventStore;
import com.mashosoft.AccountCommand.infrastructure.eventsDb.EventModelMongo;
import com.mashosoft.AccountCommand.infrastructure.eventsDb.EventStoreMongoRepository;
import com.mashosoft.AccountCommand.infrastructure.eventsKafka.KafkaEventProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountAccountEventStoreImpl implements AccountEventStore {

    private final EventStoreMongoRepository eventStoreMongoRepository;
    private final KafkaEventProducer kafkaEventProducer;

    @Override
    public void saveEvents(String aggregateId, Iterable<BaseEvent> events, Integer expectedVersion) {
        List<EventModelMongo> eventStream = eventStoreMongoRepository.findByAggregateIdentifier( aggregateId );
        if(expectedVersion != -1 && !Objects.equals( eventStream.get( eventStream.size() - 1 ).getVersion(), expectedVersion )){
            throw new RuntimeException("Concurrency exception happen because of the expected version");
        }
        Integer version = expectedVersion;
        for(BaseEvent event : events){
            version++;
            event.setVersion( version );
            EventModelMongo eventModelMongo = EventModelMongo.builder()
                .timestamp( new Date() )
                .aggregateIdentifier( aggregateId )
                .aggregateType( AccountAggregate.class.getTypeName() )
                .version( version )
                .eventType( event.getClass().getTypeName() )
                .eventData( event )
                .build();

            EventModelMongo persistedEvent = eventStoreMongoRepository.save( eventModelMongo );
            if(!persistedEvent.getId().isEmpty()){
                kafkaEventProducer.produceKafkaEvent( event.getClass().getSimpleName(),event );
            }
        }
    }

    @Override
    public List<BaseEvent> getEvents(String aggregateId) {
        List<EventModelMongo> eventStream = eventStoreMongoRepository.findByAggregateIdentifier( aggregateId );
        if(eventStream == null || eventStream.isEmpty()){
            throw new RuntimeException("Aggregate not found events ");
        }
        return eventStream.stream().map( EventModelMongo::getEventData ).collect( Collectors.toList());
    }
}
