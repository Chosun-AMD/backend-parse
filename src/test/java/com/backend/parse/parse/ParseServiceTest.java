package com.backend.parse.parse;

import com.backend.parse.AppConfig;
import com.backend.parse.Domain.Entity.DataEntity;
import com.backend.parse.Domain.Repository.DataRepository;
import com.backend.parse.Domain.Service.ParseService;
import com.backend.parse.Domain.Service.ParseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ParseServiceTest {
    @Mock
    private DataRepository dataRepository;

    @Autowired
    private AppConfig appConfig;
    private ParseService parseService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        parseService = new ParseServiceImpl(dataRepository, appConfig);
    }

    @Test
    void mongo() throws ParseException {
        // given3

        DataEntity data1 = new DataEntity("6444762d563c0c2e701581b2","12345", "test.txt", 1024, "abcd1234", true, "2023-04-23T00:05:01.818Z");
        List<DataEntity> expectedDataList = Arrays.asList(data1);

        // when
        when(dataRepository.findAll()).thenReturn(expectedDataList);
        List<DataEntity> actualDataList = parseService.getAllEntities();

        // then
        assertEquals(expectedDataList, actualDataList);
    }
}

