package com.colegio.msstudents.infraestructure.adapter.mapper;

import com.colegio.msstudents.domain.model.Student;
import com.colegio.msstudents.infraestructure.adapter.entity.StudentEntity;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentDboMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    StudentEntity toDbo(Student domain);

    @InheritInverseConfiguration
    Student toDomain(StudentEntity entity);
}