package com.backend.parse.Domain.Repository;

import com.backend.parse.Domain.Entity.DataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRepository extends MongoRepository<DataEntity, String> {

}
