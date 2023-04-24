package com.backend.parse.Domain.Service;

import com.backend.parse.AppConfig;
import com.backend.parse.Domain.Entity.DataEntity;
import com.backend.parse.Domain.Repository.DataRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ParseServiceImpl implements ParseService {
    private final DataRepository dataRepository;
    private final AppConfig appConfig;

    @Autowired
    public ParseServiceImpl(DataRepository dataRepository, AppConfig appConfig){
        this.dataRepository = dataRepository;
        this.appConfig = appConfig;
    }


    /**
     * 전체 데이터를 불러들이는 메소드입니다.
     * @return
     */
    @Override
    public List<DataEntity> getAllEntities() {
        try (MongoClient mongoClient = MongoClients.create(appConfig.ConnectmongoDB())) {
            MongoDatabase database = mongoClient.getDatabase("amd-db");
            log.info("Connected to database: {}", database.getName());
            List<DataEntity> data = dataRepository.findAll();

            log.info("data: {}", data);
            return data;
        }
    }
}
