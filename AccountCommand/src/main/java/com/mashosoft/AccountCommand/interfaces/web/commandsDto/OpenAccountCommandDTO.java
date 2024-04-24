package com.mashosoft.AccountCommand.interfaces.web.commandsDto;

import com.mashosoft.AccountCommand.eventFrameworkCore.commands.BaseCommand;
import lombok.Data;

@Data
public class OpenAccountCommandDTO extends BaseCommand {
    private String accountHolder;
    private Double openingBalance;
}
