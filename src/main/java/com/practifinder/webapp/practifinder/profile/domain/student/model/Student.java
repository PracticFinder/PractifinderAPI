package com.practifinder.webapp.practifinder.profile.domain.student.model;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.util.List;

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
    @Size(max = 50)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String email;

    @Min(value = 18, message = "La edad debe ser mayor o igual a 0")
    @Max(value = 80, message = "La edad no puede ser mayor a 120")
    private int age;

    @URL
    private String profileImg;

    @OneToMany(mappedBy = "student")
    private List<Experience> experiences;

}
