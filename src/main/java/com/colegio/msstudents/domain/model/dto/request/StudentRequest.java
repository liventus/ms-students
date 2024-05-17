package com.colegio.msstudents.domain.model.dto.request;


import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRequest {

    @NotNull
    @NotBlank
    private String id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^(activo|inactivo)$", message = "Status must be either 'activo' or 'inactivo'")
    private String status;


    @Min(4)
    private int age;
}
