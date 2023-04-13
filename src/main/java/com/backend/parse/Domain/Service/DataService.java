package com.backend.parse.Domain.Service;

import com.backend.parse.Domain.Entity.DataEntity;

public interface DataService {
    Iterable<DataEntity> getAllData();
}
