package com.backend.parse;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Getter
@Setter
@Component
public class AppConfig {
    @Value("${spring.data.mongodb.host}")
    private String url;

    @Value("${spring.data.mongodb.port}")
    private String port;

    @Value("${spring.data.mongodb.database}")
    private String db;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.pwd}")
    private String pwd;

    /**
     * mongoDB와 연결을 시도합니다.
     * @return
     *
     * @author: 황시준
     * @since : 1.0
     */
    @Bean
    public MongoClientSettings ConnectmongoDB() {
        return MongoClientSettings.builder()
                .applyToClusterSettings(builder ->
                        builder.hosts(Arrays.asList(new ServerAddress(url))))
                .credential(MongoCredential.createCredential(
                        username,
                        db,
                        pwd
                                .toCharArray()))
                .build();
    }
}