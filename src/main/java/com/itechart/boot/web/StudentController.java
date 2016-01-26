package com.itechart.boot.web;

import com.itechart.boot.domain.Student;
import com.itechart.boot.service.StudentService;
import com.itechart.boot.utils.Ajax;
import com.itechart.boot.utils.ExceptionHandlerController;
import com.itechart.boot.utils.RestException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController extends ExceptionHandlerController {

    private static final Logger LOGGER = Logger.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/persist", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> persist(@RequestParam("data") String data) throws RestException {
        try {
            if (data == null || data.equals("")) {
                return Ajax.emptyResponse();
            }
            studentService.save(data);
            return Ajax.emptyResponse();
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/getRandomData", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getRandomData() throws RestException {
        try {
            List<Student> result = studentService.findAll ();
            return Ajax.successResponse(result);
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

}