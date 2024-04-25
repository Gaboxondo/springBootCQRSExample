package com.mashosoft.AccountCommand.interfaces.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private String id;
    private Boolean active;
    private Double balance;
    private String accountHolder;
    private Integer version;
}
