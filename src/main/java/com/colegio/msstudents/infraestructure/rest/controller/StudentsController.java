package com.colegio.msstudents.infraestructure.rest.controller;


import com.colegio.msstudents.application.usecases.StudentService;
import com.colegio.msstudents.domain.model.dto.StudentDto;
import com.colegio.msstudents.domain.model.dto.request.StudentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/students")
public class StudentsController {


    private final StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> createStudent(@RequestBody StudentRequest student) {
        return studentService.createNewStudent(student);
    }

    @GetMapping("/activos")
    @ResponseStatus(HttpStatus.FOUND)
    public Flux<StudentDto> getStudentActives() {
        return studentService.getAllStudentStatusActive();
    }

}
