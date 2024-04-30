package com.mashosoft.AccountCommand.interfaces.kafka.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class RepublisEventsEventDTO {
    private String id;
    private int version;
}
