package com.itechart.boot.service;

import com.itechart.boot.domain.Data;

import java.util.List;

public interface IDataService {

    public Data save(String problem);

    public List<Data> findAll();
}