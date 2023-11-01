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
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String email;

    @Min(value = 18, message = "La edad debe ser mayor o igual a 0")
    @Max(value = 80, message = "L   a edad no puede ser mayor a 120")
    private int age;

    @URL
    private String profile_img;

}
