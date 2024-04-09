package com.github.donaldwilson8.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.github.donaldwilson8.repository")
public class MongoDBConfig {

}
