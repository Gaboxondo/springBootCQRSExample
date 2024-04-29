package com.mashosoft.AccountQuery.interfaces.kafka;

import com.mashosoft.AccountQuery.interfaces.kafka.adapter.AccountEventsInterfaceAdapter;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.AccountOpenedEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.CloseAccountEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.DepositMoneyEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.WithdrawMoneyEventDTO;
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

    @KafkaListener(topics = "AccountOpenedEvent", groupId = "${spring.kafka.consumer.group-id}",
        properties = {"spring.json.value.default.type=com.mashosoft.AccountQuery.interfaces.kafka.dto.AccountOpenedEventDTO"})
    public void consume(AccountOpenedEventDTO accountOpenedEventDTO, Acknowledgment ack){
        log.info( "Event received for account opening {}", accountOpenedEventDTO );
        accountEventsInterfaceAdapter.handle( accountOpenedEventDTO );
        ack.acknowledge();
    }

    @KafkaListener(topics = "CloseAccountEvent", groupId = "${spring.kafka.consumer.group-id}",
        properties = {"spring.json.value.default.type=com.mashosoft.AccountQuery.interfaces.kafka.dto.CloseAccountEventDTO"})
    public void consume(CloseAccountEventDTO closeAccountEventDTO, Acknowledgment ack){

    }

    @KafkaListener(topics = "DepositMoneyEvent", groupId = "${spring.kafka.consumer.group-id}",
        properties = {"spring.json.value.default.type=com.mashosoft.AccountQuery.interfaces.kafka.dto.DepositMoneyEventDTO"})
    public void consume(DepositMoneyEventDTO depositMoneyEventDTO, Acknowledgment ack){

    }

    @KafkaListener(topics = "WithdrawMoneyEvent", groupId = "${spring.kafka.consumer.group-id}",
        properties = {"spring.json.value.default.type=com.mashosoft.AccountQuery.interfaces.kafka.dto.WithdrawMoneyEventDTO"})
    public void consume(WithdrawMoneyEventDTO withdrawMoneyEventDTO, Acknowledgment ack){

    }
}
