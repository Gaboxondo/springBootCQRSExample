package com.mashosoft.AccountQuery.interfaces.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class AccountUpdateEventDTO {
    private String id;
    private Integer version;
    private String operation;
    private String accountHolder;
    private Date creationDate;
    private Double openingBalance;
    private Double amount;
}
