package com.practifinder.webapp.practifinder.profile.resource.intern;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
public class CreateStudentWithAttributesResource {

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
