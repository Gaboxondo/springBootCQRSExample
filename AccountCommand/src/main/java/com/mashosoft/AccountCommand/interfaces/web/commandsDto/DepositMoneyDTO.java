package com.mashosoft.AccountCommand.interfaces.web.commandsDto;

import com.mashosoft.AccountCommand.eventFrameworkCore.commands.BaseCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositMoneyDTO {
    private Double amount;
}
