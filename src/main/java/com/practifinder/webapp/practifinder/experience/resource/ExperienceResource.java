package com.practifinder.webapp.practifinder.experience.resource;


import lombok.*;


import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceResource {

    private Long id;

    private String empresa;

    private String cargo;

    private String descripcion;

    private Date fechaFinalizacion;

    private Date fechaInicio;
}

