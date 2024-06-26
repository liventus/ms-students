package com.colegio.msstudents.application.service;

import com.colegio.msstudents.application.exeptions.ErrorsStudents;
import com.colegio.msstudents.application.exeptions.StudentException;
import com.colegio.msstudents.application.mapper.StudentDtoMapper;
import com.colegio.msstudents.application.mapper.StudentRequestMapper;
import com.colegio.msstudents.application.usecases.StudentService;
import com.colegio.msstudents.domain.model.dto.StudentDto;
import com.colegio.msstudents.domain.model.dto.request.StudentRequest;
import com.colegio.msstudents.domain.port.StudentPersistencePort;
import com.mongodb.MongoWriteException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.handler.ExceptionHandlingWebHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentManagementService implements StudentService {

    private final StudentPersistencePort studentPersistencePort;
    private final StudentRequestMapper studentRequestMapper;
    private final StudentDtoMapper studentDtoMapper;

    public StudentManagementService(final StudentPersistencePort studentPersistencePort,
                                    final StudentRequestMapper studentRequestMapper,
                                    final StudentDtoMapper studentDtoMapper){
        this.studentPersistencePort = studentPersistencePort;
        this.studentRequestMapper = studentRequestMapper;
        this.studentDtoMapper = studentDtoMapper;
    }


    @Override
    public Mono<Void> createNewStudent(StudentRequest request) {

            var studentRequest = studentRequestMapper.toDomain(request);
            return studentPersistencePort.create(studentRequest);

    }
    @Override
    public Flux<StudentDto> getAllStudentStatusActive(String status) {
            return studentPersistencePort.getByStatus(status).map(studentDtoMapper::toDto);

    }
}
