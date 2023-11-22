package com.practifinder.webapp.practifinder.intership.resource.offer;

import com.practifinder.webapp.practifinder.profile.resource.intern.StudentResource;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class OfferInternshipStudentsResource {

    private Long id;

    private String titulo;

    private String descripcion;

    private Date fechaInicio;

    private Date fechaFin;

    private String requisitos;

    private String funciones;

    private String beneficios;

    private Boolean more;

    private String area;

    private String ubicacion;

    private Double salario;

    List<StudentResource> postulantes;
}
