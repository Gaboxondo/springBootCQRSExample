package com.mashosoft.AccountCommand.domain.events;

import com.mashosoft.AccountCommand.eventFrameworkCore.commands.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AccountOpenedEvent extends BaseEvent {
    private String accountHolder;
    private Date creationDate;
    private Double openingBalance;
}
