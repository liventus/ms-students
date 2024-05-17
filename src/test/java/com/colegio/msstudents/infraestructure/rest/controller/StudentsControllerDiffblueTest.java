package com.colegio.msstudents.infraestructure.rest.controller;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.colegio.msstudents.application.mapper.StudentDtoMapper;
import com.colegio.msstudents.application.mapper.StudentRequestMapper;
import com.colegio.msstudents.application.service.StudentManagementService;
import com.colegio.msstudents.domain.model.Student;
import com.colegio.msstudents.domain.model.dto.StudentDto;
import com.colegio.msstudents.domain.model.dto.request.StudentRequest;
import com.colegio.msstudents.infraestructure.adapter.StudentSpringJpaAdapter;
import com.colegio.msstudents.infraestructure.adapter.entity.StudentEntity;
import com.colegio.msstudents.infraestructure.adapter.mapper.StudentDboMapperImpl;
import com.colegio.msstudents.infraestructure.adapter.repository.StudentRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class StudentsControllerDiffblueTest {
    /**
     * Method under test: {@link StudentsController#createStudent(StudentRequest)}
     */
    @Test
    void testCreateStudent() throws AssertionError {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        StudentRepository studentRepository = mock(StudentRepository.class);
        Mono<StudentEntity> justResult = Mono.just(new StudentEntity());
        when(studentRepository.save(Mockito.<StudentEntity>any())).thenReturn(justResult);
        StudentSpringJpaAdapter studentPersistencePort = new StudentSpringJpaAdapter(studentRepository,
                new StudentDboMapperImpl());

        StudentRequestMapper studentRequestMapper = mock(StudentRequestMapper.class);
        when(studentRequestMapper.toDomain(Mockito.<StudentRequest>any())).thenReturn(new Student());
        StudentsController studentsController = new StudentsController(
                new StudentManagementService(studentPersistencePort, studentRequestMapper, mock(StudentDtoMapper.class)));

        // Act and Assert
        StepVerifier.FirstStep<Void> createResult = StepVerifier
                .create(studentsController.createStudent(new StudentRequest("42", "Name", "Doe", "Status", 1)));
        createResult.expectComplete().verify();
        verify(studentRequestMapper).toDomain(isA(StudentRequest.class));
        verify(studentRepository).save(isA(StudentEntity.class));
    }

    /**
     * Method under test: {@link StudentsController#getStudentActives(String)}
     */
    @Test
    void testGetStudentActives() throws AssertionError {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        StudentRepository studentRepository = mock(StudentRepository.class);
        Flux<StudentEntity> fromIterableResult = Flux.fromIterable(new ArrayList<>());
        when(studentRepository.findByStatus(Mockito.<String>any())).thenReturn(fromIterableResult);

        // Act and Assert
        StepVerifier.FirstStep<StudentDto> createResult = StepVerifier.create((new StudentsController(
                new StudentManagementService(new StudentSpringJpaAdapter(studentRepository, new StudentDboMapperImpl()),
                        mock(StudentRequestMapper.class), mock(StudentDtoMapper.class)))).getStudentActives("Status"));
        createResult.expectComplete().verify();
        verify(studentRepository).findByStatus(eq("Status"));
    }
}
