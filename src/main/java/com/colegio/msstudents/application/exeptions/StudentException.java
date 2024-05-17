package com.colegio.msstudents.application.exeptions;

public class StudentException extends RuntimeException{

    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }
}
