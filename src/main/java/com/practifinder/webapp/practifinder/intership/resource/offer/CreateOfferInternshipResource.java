package com.practifinder.webapp.practifinder.intership.resource.offer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateOfferInternshipResource {

    @NotNull
    @Size(max = 60)
    private String titulo;

    @NotNull
    @Size(max = 255)
    private String descripcion;

    @NotNull
    private Date fechaInicio;

    @NotNull
    private Date fechaFin;

    @NotNull
    @Size(max = 80)
    private String requisitos;

    @NotNull
    @Size(max = 80)
    private String funciones;

    @NotNull
    @Size(max = 80)
    private String beneficios;

    @NotNull
    private Boolean more;

    @NotNull
    @Size(max = 80)
    private String area;

    @NotNull
    @Size(max = 80)
    private String ubicacion;

    @NotNull
    private Double salario;

}
