package com.mashosoft.AccountQuery.interfaces.kafka;

import com.mashosoft.AccountQuery.interfaces.adapter.AccountEventsInterfaceAdapter;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.AccountUpdateEventDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class AccountEventConsumer {

    private final AccountEventsInterfaceAdapter accountEventsInterfaceAdapter;

    @KafkaListener(topics = "AccountUpdateEvent", groupId = "${spring.kafka.consumer.group-id}",
        properties = {"spring.json.value.default.type=com.mashosoft.AccountQuery.interfaces.kafka.dto.AccountUpdateEventDTO"})
    public void consume(AccountUpdateEventDTO accountUpdateEventDTO, Acknowledgment ack){
        log.info( "Event received for {} and id {}", accountUpdateEventDTO.getOperation(), accountUpdateEventDTO.getId() );
        accountEventsInterfaceAdapter.handle( accountUpdateEventDTO );
        ack.acknowledge();
    }
}
