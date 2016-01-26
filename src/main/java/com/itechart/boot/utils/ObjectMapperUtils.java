package com.itechart.boot.utils;

import com.itechart.boot.utils.mappign.StudentDtoToEntityMap;
import com.itechart.boot.utils.mappign.StudentToDtoMap;
import com.itechart.boot.utils.mappign.TeacherDtoToEntityMap;
import com.itechart.boot.utils.mappign.TeacherToDtoMap;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;

public final class ObjectMapperUtils {

    private static ModelMapper modelMapper;

    private ObjectMapperUtils() {
    }

    static {
        modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.addMappings(new StudentToDtoMap());
        modelMapper.addMappings(new StudentDtoToEntityMap());

        modelMapper.addMappings(new TeacherToDtoMap());
        modelMapper.addMappings(new TeacherDtoToEntityMap());
    }

    public static <D, T> D map(T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

    public static <D, T> List<D> mapAll(Iterable<T> entityList, Class<D> outCLass) {
        List<D> result = new ArrayList<>();

        for (T entity : entityList) {
            result.add(map(entity, outCLass));
        }

        return result;
    }

    public static void map(Object source, Object destination) {
        modelMapper.map(source, destination);
    }
}
