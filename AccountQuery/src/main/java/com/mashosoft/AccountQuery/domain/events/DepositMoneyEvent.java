package com.mashosoft.AccountQuery.domain.events;

import com.mashosoft.AccountQuery.eventFrameworkCore.events.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DepositMoneyEvent extends BaseEvent {
    private Double amount;
}
