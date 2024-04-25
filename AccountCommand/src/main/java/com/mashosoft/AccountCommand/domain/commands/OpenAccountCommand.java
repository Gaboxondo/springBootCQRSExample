package com.mashosoft.AccountCommand.domain.commands;

import com.mashosoft.AccountCommand.eventFrameworkCore.commands.BaseCommand;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OpenAccountCommand extends BaseCommand {
    private String accountHolder;
    private Double openingBalance;
}
