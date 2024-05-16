package com.colegio.msstudents.application.mapper;


import com.colegio.msstudents.domain.model.Student;
import com.colegio.msstudents.domain.model.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentDtoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "age", target = "age")
    StudentDto toDto(Student domain);
}
