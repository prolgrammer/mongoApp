package org.example.services;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

    @Service
    public class MongoServiceImpl implements MongoService{

        public MongoTemplate mongoTemplate(String name, String password) {
            String connectionString = "mongodb://" + name + ":" + password + "@localhost:27017/MarketDB";
            MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(connectionString))
                    .build();
            MongoClient mongoClient = MongoClients.create(mongoClientSettings);
            System.out.println(connectionString);
            return new MongoTemplate(mongoClient, "MarketDB");
        }
    }
