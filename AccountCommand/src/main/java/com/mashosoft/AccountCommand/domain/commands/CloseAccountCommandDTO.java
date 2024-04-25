package com.mashosoft.AccountCommand.domain.commands;

import com.mashosoft.AccountCommand.eventFrameworkCore.commands.BaseCommand;
import lombok.Data;

public class CloseAccountCommandDTO extends BaseCommand {
    public CloseAccountCommandDTO(String id){
        super(id);
    }
}
