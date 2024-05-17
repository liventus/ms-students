package com.colegio.msstudents.infraestructure.rest.controller;


import com.colegio.msstudents.application.usecases.StudentService;
import com.colegio.msstudents.domain.model.dto.StudentDto;
import com.colegio.msstudents.domain.model.dto.request.StudentRequest;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "usuario registrado correctamente"),
            @ApiResponse(responseCode = "400",description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "500",description = "error en el servidor")
    })
    public Mono<Void> createStudent(@Valid @RequestBody StudentRequest student) {
        return studentService.createNewStudent(student);
    }

    @GetMapping(value = "/{status}",produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.FOUND)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "usuario registrado correctamente"),
            @ApiResponse(responseCode = "400",description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "500",description = "error en el servidor")
    })
    public Flux<StudentDto> getStudentActives(@Valid @PathVariable String status) {
        System.out.println(status);
        return studentService.getAllStudentStatusActive();
    }

}
