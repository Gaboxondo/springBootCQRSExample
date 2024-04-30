package com.mashosoft.AccountQuery.domain.events;

import com.mashosoft.AccountQuery.eventFrameworkCore.events.BaseEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class RepublishEventsEvent extends BaseEvent {
}
