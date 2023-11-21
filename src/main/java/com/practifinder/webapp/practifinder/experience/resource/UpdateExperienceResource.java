package com.practifinder.webapp.practifinder.experience.resource;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class UpdateExperienceResource {

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
