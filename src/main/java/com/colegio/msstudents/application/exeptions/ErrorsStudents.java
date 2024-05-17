package com.colegio.msstudents.application.exeptions;

import lombok.Getter;

@Getter
public enum ErrorsStudents {
    ERROR_A("E001","Error creando el registro de estudiante"),
    ERROR_B("E002","Error al recuperar estudiantes por estado"),
    ;
    private final String codeAdvice;
    private final String message;


    ErrorsStudents(String codeAdvice, String message) {
        this.codeAdvice = codeAdvice;
        this.message = message;
    }

}
