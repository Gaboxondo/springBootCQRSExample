package com.mashosoft.AccountCommand.interfaces.kafka;

import com.mashosoft.AccountCommand.interfaces.adapter.AccountInterfaceAdapter;
import com.mashosoft.AccountCommand.interfaces.kafka.dto.RepublisEventsEventDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ReadDbEventConsumer {

    private final AccountInterfaceAdapter accountInterfaceAdapter;

    @KafkaListener(topics = "RepublishEventsEvent", groupId = "${spring.kafka.consumer.group-id}",
        properties = {"spring.json.value.default.type=com.mashosoft.AccountCommand.interfaces.kafka.dto.RepublisEventsEventDTO"})
    public void consume(RepublisEventsEventDTO republisEventsEventDTO, Acknowledgment ack){
        log.info( "Event received for {}", republisEventsEventDTO );
        accountInterfaceAdapter.restoreDbRepublishingEvents();
        ack.acknowledge();
    }
}
