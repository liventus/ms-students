package com.colegio.msstudents.application.exeptions;

public class StudentRetrievalException extends RuntimeException{

    public StudentRetrievalException(String message, Throwable cause) {
        super(message, cause);
    }
}
