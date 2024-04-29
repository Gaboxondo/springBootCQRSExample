package com.mashosoft.AccountQuery.interfaces.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountReadDTO {

    private String id;
    private String accountHolder;
    private Date creationDate;
    private Double balance;
    private Integer version;
}
