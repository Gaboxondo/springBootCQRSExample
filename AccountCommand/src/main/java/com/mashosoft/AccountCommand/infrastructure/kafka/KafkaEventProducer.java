package com.mashosoft.AccountCommand.infrastructure.kafka;

import com.mashosoft.AccountCommand.eventFrameworkCore.events.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaEventProducer {

    private final KafkaTemplate<String,BaseEvent> kafkaTemplate;

    public void produceKafkaEvent(String topic, BaseEvent baseEvent){
        log.info( "Publishing event for {} with id {} and version {}", baseEvent.getClass().getSimpleName(),
            baseEvent.getId(), baseEvent.getVersion() );
        this.kafkaTemplate.send( topic,baseEvent );
    }
}
