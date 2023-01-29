package com.steve.repository;

import com.steve.core.ExampleData;
import com.steve.core.ExampleRepositoryAdapter;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Optional;

public class ExampleRepository implements ExampleRepositoryAdapter {

    private final MongoTemplate mongoTemplate;

    public ExampleRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Optional<ExampleData> storeState(ExampleData data) {
        ExampleData exampleData = mongoTemplate.save(data);
        return Optional.of(exampleData);
    }
}
