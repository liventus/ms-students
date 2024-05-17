package com.colegio.msstudents.application.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.colegio.msstudents.application.mapper.StudentDtoMapper;
import com.colegio.msstudents.application.mapper.StudentRequestMapper;
import com.colegio.msstudents.domain.model.Student;
import com.colegio.msstudents.domain.model.dto.request.StudentRequest;
import com.colegio.msstudents.domain.port.StudentPersistencePort;

import java.util.ArrayList;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {StudentManagementService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class StudentManagementServiceTest {
    @MockBean
    private StudentDtoMapper studentDtoMapper;

    @Autowired
    private StudentManagementService studentManagementService;

    @MockBean
    private StudentPersistencePort studentPersistencePort;

    @MockBean
    private StudentRequestMapper studentRequestMapper;

    @Test
    void testCreateNewStudent() {
        // Arrange
        Flux<?> source = Flux.fromIterable(new ArrayList<>());
        ChannelSendOperator<Object> channelSendOperator = new ChannelSendOperator<>(source, mock(Function.class));

        when(studentPersistencePort.create(Mockito.<Student>any())).thenReturn(channelSendOperator);
        when(studentRequestMapper.toDomain(Mockito.<StudentRequest>any())).thenReturn(new Student());

        // Act
        Mono<Void> actualCreateNewStudentResult = studentManagementService
                .createNewStudent(new StudentRequest("42", "Name", "Doe", "Status", 1));

        // Assert
        verify(studentRequestMapper).toDomain(isA(StudentRequest.class));
        verify(studentPersistencePort).create(isA(Student.class));
        assertSame(channelSendOperator, actualCreateNewStudentResult);
    }
}
