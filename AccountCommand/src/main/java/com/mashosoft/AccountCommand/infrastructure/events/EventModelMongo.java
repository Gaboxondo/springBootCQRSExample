package com.mashosoft.AccountCommand.infrastructure.events;

import com.mashosoft.AccountCommand.eventFrameworkCore.events.BaseEvent;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "accountEventStore")
public class EventModelMongo {

    @Id
    private String id;
    private Date timestamp;
    private String aggregateIdentifier;
    private String aggregateType;
    private Integer version;
    private String eventType;
    private BaseEvent eventData;
}
