package com.backend.parse.parse;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * Parsing을 Test하는 코드입니다.
 * @author : 황시준
 * @since  : 1.0
 */
public class DatabaseConnectTest {

    private String url = "117.16.17.166";
    private int port = 27017;
    private String db = "amd-db";
    private String username = "amd-user";
    private String pwd = "amd-user166#@";

    @Test
    void connectTest(){
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToClusterSettings(builder ->
                        builder.hosts(Arrays.asList(new ServerAddress(url, port))))
                .credential(MongoCredential.createCredential(
                        username,
                        db,
                        pwd
                .toCharArray()))
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("amd-db");
        mongoClient.close();
    }
}
