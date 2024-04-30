package com.mashosoft.AccountQuery.infrastructure.kafka;

import com.mashosoft.AccountQuery.eventFrameworkCore.events.BaseEvent;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaEventProducer {

    private final KafkaTemplate<String,BaseEvent> kafkaTemplate;

    public void produceKafkaEvent(String topic, BaseEvent baseEvent){
        this.kafkaTemplate.send( topic,baseEvent );
    }
}
