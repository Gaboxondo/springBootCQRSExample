package com.mashosoft.AccountCommand.infrastructure.eventsKafka;

import com.mashosoft.AccountCommand.eventFrameworkCore.events.BaseEvent;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaEventProducer {

    private final KafkaTemplate<String,Object> kafkaTemplate;

    public void produceKafkaEvent(String topic, BaseEvent baseEvent){
        this.kafkaTemplate.send( topic,baseEvent );
    }
}
