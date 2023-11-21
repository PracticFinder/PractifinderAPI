package com.practifinder.webapp.practifinder.experience.resource;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateExperienceResource {


    @NotNull
    @Size(max = 50)
    private String empresa;

    @NotNull
    @Size(max = 50)
    private String cargo;

    @NotNull
    @Size(max = 250)
    private String descripcion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaFinalizacion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;
}
