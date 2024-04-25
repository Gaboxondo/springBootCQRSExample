package com.mashosoft.AccountCommand.domain.commands;

import com.mashosoft.AccountCommand.eventFrameworkCore.commands.BaseCommand;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class DepositMoneyCommand extends BaseCommand {
    private Double amount;
}
