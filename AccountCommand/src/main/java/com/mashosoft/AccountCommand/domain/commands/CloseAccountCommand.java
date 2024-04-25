package com.mashosoft.AccountCommand.domain.commands;

import com.mashosoft.AccountCommand.eventFrameworkCore.commands.BaseCommand;

public class CloseAccountCommand extends BaseCommand {
    public CloseAccountCommand(String id){
        super(id);
    }
}
