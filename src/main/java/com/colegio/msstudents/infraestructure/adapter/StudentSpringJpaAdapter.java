package com.colegio.msstudents.infraestructure.adapter;

import com.colegio.msstudents.domain.model.Student;
import com.colegio.msstudents.domain.port.StudentPersistencePort;
import com.colegio.msstudents.infraestructure.adapter.mapper.StudentDboMapper;
import com.colegio.msstudents.infraestructure.adapter.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class StudentSpringJpaAdapter implements StudentPersistencePort {

    private final StudentRepository studentRepository;
    private final StudentDboMapper studentDboMapper;

    public StudentSpringJpaAdapter(StudentRepository studentRepository, StudentDboMapper studentDboMapper){
        this.studentRepository = studentRepository;
        this.studentDboMapper = studentDboMapper;
    }

    @Override
    public Mono<Void> create(Student student) {
        return studentRepository.insert(studentDboMapper.toDbo(student)).then();

    }

    @Override
    public Flux<Student> getAll() {
        return studentRepository.findAll().map(studentDboMapper::toDomain);
    }

    @Override
    public Flux<Student> getByStatus(String status) {
        return studentRepository.findByStatus(status).map(studentDboMapper::toDomain);
    }
}
