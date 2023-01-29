package com.steve.configuration;

import com.steve.core.CoreService;
import com.steve.core.ExampleRepositoryAdapter;
import com.steve.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class ExampleApplicationConfiguration {

    private final MongoTemplate mongoTemplate;

    public ExampleApplicationConfiguration(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Bean
    public ExampleRepositoryAdapter exampleRepository() {
        return new ExampleRepository(mongoTemplate);
    }

    @Bean
    public CoreService coreService() {
        return new CoreService(exampleRepository());
    }

}
