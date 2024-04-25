package com.mashosoft.AccountCommand.infrastructure.events;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventStoreMongoRepository extends MongoRepository<EventModelMongo, String> {

    List<EventModelMongo> findByAggregateIdentifier(String aggregateIdentifier);
}
