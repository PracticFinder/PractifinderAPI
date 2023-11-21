package com.practifinder.webapp.practifinder.profile.resource.intern;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
public class UpdateStudentResource {


    @NotNull
    @Size(max = 100)
    private String nombre;

    @NotNull
    private String correo;

    @NotNull
    @Size(max = 50)
    private String username;

    @NotNull
    @Size(max = 50)
    private String password;

    @NotNull
    private Long rolId;

    @URL
    private String imagen;


    @Min(value = 18, message = "La edad debe ser mayor o igual a 0")
    @Max(value = 80, message = "La edad no puede ser mayor a 120")
    private int edad;


    @Size(max = 50)
    private String direccion;


    @Size(max=12)
    private String telefono;

}
