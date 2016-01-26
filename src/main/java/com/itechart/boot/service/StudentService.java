package com.itechart.boot.service;

import com.itechart.boot.domain.Student;
import com.itechart.boot.dto.StudentDTO;
import com.itechart.boot.repository.StudentRepository;
import com.itechart.boot.utils.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.itechart.boot.utils.ObjectMapperUtils.map;
import static com.itechart.boot.utils.ObjectMapperUtils.mapAll;

@Service
public class StudentService implements IStudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO getStudent(Integer id) {
        Student student = studentRepository.findOne(id);

        return map(student, StudentDTO.class);
    }

    public StudentDTO getStudentByFirstName(String firstName) {
        Student student = studentRepository
                .findByFirstName(firstName)
                .orElseThrow(() -> new EntityNotFoundException("Student was not found."));

        return map(student, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getAll() {
        List<Student> students = studentRepository.findAll();

        return mapAll(students, StudentDTO.class);
    }

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        Student student = map(studentDTO, Student.class);

        student = studentRepository.save(student);

        return map(student, StudentDTO.class);
    }
}