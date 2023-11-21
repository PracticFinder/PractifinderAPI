package com.practifinder.webapp.practifinder.profile.domain.intern.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name = "nombre", unique = true)
    private String nombre;

    @NotNull
    @Email
    @Column(name = "correo")
    private String correo;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "username", unique = true)
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "rolId")
    private Long rolId;



    @Column(name = "imagen")
    @URL
    private String imagen;

    @Min(value = 18, message = "La edad debe ser mayor o igual a 0")
    @Max(value = 80, message = "La edad no puede ser mayor a 120")
    @Column(name = "edad")
    private int edad;


    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;


    @Size(max=12)
    @Column(name = "telefono")
    private String telefono;


}
