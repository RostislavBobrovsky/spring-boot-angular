package com.itechart.boot.service;

import com.itechart.boot.domain.Student;
import com.itechart.boot.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(String problem) {
        Student student = new Student();

        student.setFirstName(problem);
        student.setLastName(problem);
        student.setBirthDate(new Date(Calendar.getInstance().getTime().getTime()));

        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}