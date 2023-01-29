package com.steve.repository.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@ConfigurationPropertiesScan("com.steve.repository")
public class MongoDbConfiguration {

    private final MongoProperties mongoProperties;

    public MongoDbConfiguration(MongoProperties mongoProperties) {
        System.out.println(mongoProperties.getDatabase());
        this.mongoProperties = mongoProperties;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), mongoProperties.getDatabase());
    }

    public MongoClient mongoClient() {
        ConnectionString connectionString = getConnectionString();
        MongoClientSettings mongoClientSettings = mongoClientSettings(connectionString);

        return MongoClients.create(mongoClientSettings);
    }

    private MongoClientSettings mongoClientSettings(ConnectionString connectionString) {
        return MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
    }

    private ConnectionString getConnectionString() {
        String hostname = mongoProperties.getHost();
        String port = mongoProperties.getPort();
        return new ConnectionString("mongodb://" + hostname + ":" + port);
    }

}
