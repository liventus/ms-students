package com.colegio.msstudents.application.usecases;

import com.colegio.msstudents.domain.model.dto.StudentDto;
import com.colegio.msstudents.domain.model.dto.request.StudentRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

    Mono<Void> createNewStudent(StudentRequest studentRequest);
    Flux<StudentDto> getAllStudentStatusActive();

}
