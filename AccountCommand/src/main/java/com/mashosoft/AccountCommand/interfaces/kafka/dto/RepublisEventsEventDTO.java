package com.mashosoft.AccountCommand.interfaces.kafka.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@ToString
public class RepublisEventsEventDTO {
    private String id;
    private int version;
}
