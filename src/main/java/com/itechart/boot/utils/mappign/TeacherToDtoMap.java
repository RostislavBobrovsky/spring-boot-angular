package com.itechart.boot.utils.mappign;

import com.itechart.boot.domain.Teacher;
import com.itechart.boot.dto.TeacherDTO;
import org.modelmapper.PropertyMap;

public class TeacherToDtoMap extends PropertyMap<Teacher, TeacherDTO> {

    @Override
    protected void configure() {
        map().setId(source.getId());
        map().setFirstName(source.getFirstName());
        map().setLastName(source.getLastName());
    }
}
