package com.colegio.msstudents.domain.model.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRequest {

    private String id;
    private String name;
    private String lastName;
    private String status;
    private int age;
}
