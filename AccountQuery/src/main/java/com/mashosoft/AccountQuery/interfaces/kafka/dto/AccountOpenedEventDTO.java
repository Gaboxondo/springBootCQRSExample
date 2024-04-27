package com.mashosoft.AccountQuery.interfaces.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AccountOpenedEventDTO {
    private String id;
    private int version;
    private String accountHolder;
    private Date creationDate;
    private Double openingBalance;
}
