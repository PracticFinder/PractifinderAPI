package com.practifinder.webapp.practifinder.intership.resource.offer;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class OfferInternshipResource {

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

}
