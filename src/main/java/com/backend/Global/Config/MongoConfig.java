package com.backend.Global.Config;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriUtils;
import java.nio.charset.StandardCharsets;


@Getter
@Setter
@Component
@Slf4j
/**
 * MongoDB와의 연결울 설정하는 부분입니다.
 */
public class MongoConfig extends AbstractMongoClientConfiguration {
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
    @Override
    public MongoClient mongoClient() {
        String encodedUsername = UriUtils.encode(username, StandardCharsets.UTF_8);
        String encodedPassword = UriUtils.encode(pwd, StandardCharsets.UTF_8);

        ConnectionString connectionString = new ConnectionString("mongodb://" + encodedUsername + ":" + encodedPassword + "@" + url + ":" + port + "/" + db);
        log.info("mongodb url : {}", connectionString);
        return MongoClients.create(connectionString);
    }

    @Override
    protected String getDatabaseName() {
        return db;
    }
}