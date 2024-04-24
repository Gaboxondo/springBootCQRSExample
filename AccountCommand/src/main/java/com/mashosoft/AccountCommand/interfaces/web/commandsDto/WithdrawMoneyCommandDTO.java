package com.mashosoft.AccountCommand.interfaces.web.commandsDto;

import com.mashosoft.AccountCommand.eventFrameworkCore.commands.BaseCommand;
import lombok.Data;

@Data
public class WithdrawMoneyCommandDTO extends BaseCommand {
    private Double amount;
}
