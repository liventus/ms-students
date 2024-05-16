package com.colegio.msstudents.infraestructure.adapter.repository;

import com.colegio.msstudents.infraestructure.adapter.entity.StudentEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends ReactiveMongoRepository<StudentEntity, String> {
}
