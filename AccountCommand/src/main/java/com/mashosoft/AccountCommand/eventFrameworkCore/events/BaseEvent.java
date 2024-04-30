package com.mashosoft.AccountCommand.eventFrameworkCore.events;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class BaseEvent {
    private String operation;
    private String id;
    private int version;
}
