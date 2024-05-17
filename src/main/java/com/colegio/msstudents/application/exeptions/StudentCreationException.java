package com.colegio.msstudents.application.exeptions;

public class StudentCreationException extends RuntimeException{

    public StudentCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
