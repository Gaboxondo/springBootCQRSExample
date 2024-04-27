package com.mashosoft.AccountQuery.interfaces.kafka.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class CloseAccountEventDTO {
    private String id;
    private int version;
}
