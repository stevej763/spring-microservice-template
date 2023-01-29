package com.steve.repository.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mongo")
public class MongoProperties {

    private final String database;
    private final String host;
    private final String port;

    public MongoProperties(String database, String host, String port) {
        System.out.println("mongo properties creating");
        this.database = database;
        this.host = host;
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }
}
