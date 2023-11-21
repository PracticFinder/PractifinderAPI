package com.practifinder.webapp.practifinder.profile.domain.business.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.URL;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "business")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;

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
    @Email
    @Column(name = "correo")
    private String correo;

    @NotNull
    @Column(name = "rolId")
    private Long rolId;


    @Size(max = 200)
    private String location;


    @Column(name = "imagen")
    @URL
    private String imagen;


    @Size(max = 200)
    @Column(name = "siteWeb")
    private String siteWeb;

}