package com.backend.parse.Domain.Repository;

import com.backend.parse.Domain.Entity.DataEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReactiveDataRepository extends ReactiveMongoRepository<DataEntity, String> {
}
