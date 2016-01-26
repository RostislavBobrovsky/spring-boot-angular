package com.itechart.boot.service;

import com.itechart.boot.domain.Student;

import java.util.List;

public interface IStudentService {

    public Student save(String problem);

    public List<Student> findAll();
}