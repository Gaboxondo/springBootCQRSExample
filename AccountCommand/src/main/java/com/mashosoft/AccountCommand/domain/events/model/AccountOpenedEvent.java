package com.mashosoft.AccountCommand.domain.events.model;

import com.mashosoft.AccountCommand.eventFrameworkCore.events.BaseEvent;
import lombok.*;
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
