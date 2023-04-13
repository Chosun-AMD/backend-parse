package com.backend.parse.Domain.DataRepository;

import com.backend.parse.Domain.Entity.DataEntity;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<DataEntity, Long> {
    DataEntity findByfileId(String file_id);
}
