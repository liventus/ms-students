package com.colegio.msstudents.application.mapper;

import com.colegio.msstudents.domain.model.Student;
import com.colegio.msstudents.domain.model.dto.request.StudentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentRequestMapper {


    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "status", target = "status")
    Student toDomain(StudentRequest request);
}




