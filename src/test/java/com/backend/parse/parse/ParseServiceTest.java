package com.backend.parse.parse;

import com.backend.parse.Domain.Entity.DataEntity;
import com.backend.parse.Domain.Repository.DataRepository;
import com.backend.parse.Domain.Service.ParseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.text.ParseException;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RequiredArgsConstructor
@Slf4j
public class ParseServiceTest {

    @Autowired
    private 
    dataRepository;

    @Autowired
    private ParseService parseService;

    @Autowired
    private MongoTemplate mongoTemplate;


    @BeforeEach
    public void setup() throws ParseException {
        DataEntity entity1 = new DataEntity("6442d5f4f4d8db7a3a529f54", "3433333", "test.txt", 1024, "abcd1234", true, "2023-04-21T18:29:08.358Z");
        DataEntity entity2 = new DataEntity("6444762d563c0c2e701581b2", "12346", "test.txt", 1024, "abcd1234", true, "2023-04-23T00:05:01.818Z");
        dataRepository.save(entity1);
        dataRepository.save(entity2);
    }


    @Test
    void getAllEntities() {
        List<DataEntity> expectedDataList = mongoTemplate.findAll(DataEntity.class);
        List<DataEntity> resultDataList = parseService.getAllEntities();
        assertEquals(expectedDataList.size(), resultDataList.size());
        for (int i = 0; i < expectedDataList.size(); i++) {
            assertEquals(expectedDataList.get(i), resultDataList.get(i));
        }
    }

    @AfterEach
    public void tearDown() {
        dataRepository.deleteAll();
    }


}



