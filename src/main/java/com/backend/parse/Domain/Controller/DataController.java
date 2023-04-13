package com.backend.parse.Domain.Controller;

import com.backend.parse.Domain.DTO.ResponseDataDTO;
import com.backend.parse.Domain.Entity.DataEntity;
import com.backend.parse.Domain.Service.DataService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/parse")
public class DataController {
    private final Environment env;
    private final DataService dataService;

    public DataController(Environment env, DataService dataService) {
        this.env = env;
        this.dataService = dataService;
    }

    /**
     * Health Check에 쓰이는 API입니다
     *
     * @return : server.port
     * @author : 황시준
     * @since : 1.0
     */
    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in User Service on PORT  %s",
                env.getProperty("local.server.port"));
    }

    /**
     * 전체 데이터를 조회하는 API입니다.
     * @param user
     * @return ResponseUser
     * @author : 황시준
     * @since : 1.0
     */
    @GetMapping("/getAllData")
    public ResponseEntity<List<ResponseDataDTO>> getData() {
        Iterable<DataEntity> dataList = dataService.getAllData();

        List<ResponseDataDTO> result = new ArrayList<>();
        dataList.forEach(v -> {
            result.add(new ModelMapper().map(v, ResponseDataDTO.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
