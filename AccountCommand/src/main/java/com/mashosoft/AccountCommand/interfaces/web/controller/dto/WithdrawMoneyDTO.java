package com.mashosoft.AccountCommand.interfaces.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class WithdrawMoneyDTO {
    private Double amount;
}
