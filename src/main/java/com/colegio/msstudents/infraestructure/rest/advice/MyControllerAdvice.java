package com.colegio.msstudents.infraestructure.rest.advice;



import com.colegio.msstudents.infraestructure.adapter.exception.StudentException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {



    @ExceptionHandler(StudentException.class)
    public ResponseEntity<String> handleEmptyInput(StudentException emptyInputException){
        return new ResponseEntity<String>(emptyInputException.getErrorMessage(), emptyInputException.getErrorCode());
    }

}
