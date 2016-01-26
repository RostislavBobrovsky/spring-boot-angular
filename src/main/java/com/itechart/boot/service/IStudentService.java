package com.itechart.boot.service;

import com.itechart.boot.dto.StudentDTO;

import java.util.List;

public interface IStudentService {

    public StudentDTO getStudent(Integer id);

    public StudentDTO save(StudentDTO studentDTO);

    public List<StudentDTO> getAll();
}