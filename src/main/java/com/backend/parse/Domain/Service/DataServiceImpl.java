package com.backend.parse.Domain.Service;

import com.backend.parse.Domain.DataRepository.DataRepository;
import com.backend.parse.Domain.Entity.DataEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Slf4j
@Service
public class DataServiceImpl implements DataService {
    DataRepository dataRepository;

    @Autowired
    public DataServiceImpl(DataRepository dataRepository){
        this.dataRepository = dataRepository;
    }

    @Override
    public Iterable<DataEntity> getAllData() {
        return dataRepository.findAll();
    }
}
