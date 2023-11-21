package com.practifinder.webapp.practifinder.profile.resource.intern;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.URL;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class StudentResource {
    private Long id;

    private String nombre;

    private String correo;

    private String username;

    private String password;

    private Long rolId;

    private String imagen;

    private int edad;

    private String direccion;


    private String telefono;
}