package com.desafio.anota.ai.odivanmarcos.config.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

public class MongoDBConfig {

    @Bean
    public MongoDatabaseFactory mongoConfigure(){
        return new SimpleMongoClientDatabaseFactory("mongodb://127.0.0.1:27017/?directConnection=true&serverSelectionTimeoutMS=2000&appName=mongosh+2.1.1");
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoConfigure());
    }
}