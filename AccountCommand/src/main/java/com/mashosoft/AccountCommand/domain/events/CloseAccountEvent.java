package com.mashosoft.AccountCommand.domain.events;

import com.mashosoft.AccountCommand.eventFrameworkCore.commands.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class CloseAccountEvent extends BaseEvent {
}
