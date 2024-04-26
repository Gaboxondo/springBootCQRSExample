package com.mashosoft.AccountCommand.infrastructure.eventsKafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class AutoTopicCreator {

    @Bean
    public KafkaAdmin.NewTopics topics456() {
        return new KafkaAdmin.NewTopics(
            TopicBuilder.name("AccountOpenedEvent")
                .build(),
            TopicBuilder.name("CloseAccountEvent")
                .build(),
            TopicBuilder.name("WithdrawMoneyEvent")
                .build(),
            TopicBuilder.name("DepositMoneyEvent")
                .build());
    }
}
