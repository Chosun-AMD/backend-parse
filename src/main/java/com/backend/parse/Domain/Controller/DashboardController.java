package com.backend.parse.Domain.Controller;

import com.backend.parse.Domain.Entity.DataEntity;
import com.backend.parse.Domain.Repository.ReactiveDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class DashboardController {
    private final ReactiveDataRepository reactiveDataRepository;


    /**
     * 전체 데이터를 amd-data collection에 저장된 데이터를 실시간으로 가져오는 메소드입니다.
     * 단, 현재는 단순히; 데이터를 가져왔지만 추후 Apache Kafka를 통해 속도를 향상시킬 계획입니다.
     * @return : Mono<ResponseEntity<List<DataEntity>>>
     * @author : 황시준
     * @since : 1.0
     */
    @PostMapping("/dashboard")
    public Mono<ResponseEntity<List<DataEntity>>> getMyDocuments() {
        Flux<DataEntity> dataEntityFlux = reactiveDataRepository.findAll();
        return dataEntityFlux.collectList()
                .map(dataEntities -> ResponseEntity.ok().body(dataEntities))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
