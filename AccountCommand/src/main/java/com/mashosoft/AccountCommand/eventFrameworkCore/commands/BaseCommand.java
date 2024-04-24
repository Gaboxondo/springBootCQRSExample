package com.mashosoft.AccountCommand.eventFrameworkCore.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseCommand {
    private String id;
}
