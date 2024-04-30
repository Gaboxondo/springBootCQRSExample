package com.mashosoft.AccountCommand.interfaces.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAccountDTO {
    private String accountHolder;
    private Double openingBalance;
}
