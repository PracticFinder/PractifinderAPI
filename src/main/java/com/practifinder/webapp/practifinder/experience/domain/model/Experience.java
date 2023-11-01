package com.practifinder.webapp.practifinder.experience.domain.model;

import com.practifinder.webapp.practifinder.profile.domain.student.model.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name="Experience")
public class Experience {

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
    private String jobPosition;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private int description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaFinal;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
