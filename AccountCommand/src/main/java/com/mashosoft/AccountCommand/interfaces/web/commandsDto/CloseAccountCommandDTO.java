package com.mashosoft.AccountCommand.interfaces.web.commandsDto;

import com.mashosoft.AccountCommand.eventFrameworkCore.commands.BaseCommand;
import lombok.Data;

public class CloseAccountCommandDTO extends BaseCommand {
    public CloseAccountCommandDTO(String id){
        super(id);
    }
}
