package com.colegio.msstudents.infraestructure.adapter.repository;

import com.colegio.msstudents.infraestructure.adapter.entity.StudentEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface StudentRepository extends ReactiveMongoRepository<StudentEntity, String> {

    Flux<StudentEntity> findByStatus(String status);
    //Mono<StudentEntity> findById(String id);
}
