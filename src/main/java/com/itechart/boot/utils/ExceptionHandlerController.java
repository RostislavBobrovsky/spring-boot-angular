package com.itechart.boot.utils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionHandlerController {

    private static final Logger LOGGER = Logger.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(RestException.class)
    public @ResponseBody
    String handleException(RestException e) {
        LOGGER.error("Ошибка: " + e.getMessage(), e);
        return "Ошибка: " + e.getMessage();
    }
}