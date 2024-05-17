package com.colegio.msstudents.infraestructure.rest.controller;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.colegio.msstudents.application.mapper.StudentDtoMapper;
import com.colegio.msstudents.application.mapper.StudentRequestMapper;
import com.colegio.msstudents.application.service.StudentManagementService;
import com.colegio.msstudents.domain.model.Student;
import com.colegio.msstudents.domain.model.dto.request.StudentRequest;
import com.colegio.msstudents.infraestructure.adapter.StudentSpringJpaAdapter;
import com.colegio.msstudents.infraestructure.adapter.entity.StudentEntity;
import com.colegio.msstudents.infraestructure.adapter.mapper.StudentDboMapperImpl;
import com.colegio.msstudents.infraestructure.adapter.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
}
