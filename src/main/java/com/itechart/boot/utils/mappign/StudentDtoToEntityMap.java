package com.itechart.boot.utils.mappign;

import com.itechart.boot.domain.Student;
import com.itechart.boot.dto.StudentDTO;
import org.modelmapper.PropertyMap;

public class StudentDtoToEntityMap extends PropertyMap<StudentDTO, Student> {

    @Override
    protected void configure() {
        map().setId(source.getId());
        map().setFirstName(source.getFirstName());
        map().setLastName(source.getLastName());
        map().setBirthDate(source.getBirthDate());
        map().setHostelLive(source.getHostelLive());
    }
}
