package com.itechart.boot.web;

import com.itechart.boot.dto.StudentDTO;
import com.itechart.boot.service.StudentService;
import com.itechart.boot.utils.ExceptionHandlerController;
import com.itechart.boot.utils.RequestDTOValidationException;
import com.itechart.boot.utils.RestException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController extends ExceptionHandlerController {
    private static final Logger LOGGER = Logger.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody StudentDTO getStudent(@PathVariable("id") Integer id) {
        return studentService.getStudent(id);
    }

    @RequestMapping(value = "/all-bookings", method = RequestMethod.GET)
    public @ResponseBody List<StudentDTO> getAll() throws RestException {
        return studentService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody StudentDTO save(@Valid @RequestBody StudentDTO studentDTO) throws RestException {
        if (studentDTO.getId() != null) {
            throw new RequestDTOValidationException("Student ID should be null");
        }

        return studentService.save(studentDTO);
    }
}