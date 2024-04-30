package com.mashosoft.AccountQuery.interfaces.kafka.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@ToString
public class CloseAccountEventDTO {
    private String id;
    private int version;
}
