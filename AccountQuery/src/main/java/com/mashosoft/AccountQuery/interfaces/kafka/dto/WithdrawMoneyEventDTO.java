package com.mashosoft.AccountQuery.interfaces.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class WithdrawMoneyEventDTO {
    private Double amount;
    private String id;
    private int version;
}
