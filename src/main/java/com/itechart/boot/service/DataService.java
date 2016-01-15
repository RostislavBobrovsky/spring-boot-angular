package com.itechart.boot.service;

import com.itechart.boot.domain.Data;
import com.itechart.boot.repository.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService implements IDataService {

    private static final Logger LOG = LoggerFactory.getLogger(DataService.class);

    @Autowired
    private DataRepository dataRepository;

    @Override
    public Data save(String problem) {
        Data data = new Data();

        data.setDescription(problem);

        return dataRepository.save(data);
    }

    @Override
    public List<Data> findAll() {
        return dataRepository.findAll();
    }
}