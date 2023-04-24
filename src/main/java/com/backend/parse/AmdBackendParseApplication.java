package com.backend.parse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class AmdBackendParseApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmdBackendParseApplication.class, args);
    }

}
