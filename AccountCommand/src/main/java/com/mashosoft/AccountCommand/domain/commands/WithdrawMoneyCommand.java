package com.mashosoft.AccountCommand.domain.commands;

import com.mashosoft.AccountCommand.eventFrameworkCore.commands.BaseCommand;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class WithdrawMoneyCommand extends BaseCommand {
    private Double amount;
}
