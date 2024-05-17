package com.colegio.msstudents.domain.port;

import com.colegio.msstudents.domain.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StudentPersistencePort {

    Mono<Void> create(Student student);

    Flux<Student> getAll();

    Flux<Student> getByStatus(String status);




}
