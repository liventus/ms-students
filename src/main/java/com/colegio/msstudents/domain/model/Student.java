package com.colegio.msstudents.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    private String id;
    private String name;
    private String lastName;
    private String status;
    private int age;
    private LocalDateTime dateOfCreation;

    public void setInitialValues(){

        this.dateOfCreation = LocalDateTime.now();
    }

}
