package com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.model;

import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SkillInterpersonal")
public class SkillInterpersonal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max=20)
    @Column(name = "nombre", unique = true)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "student_id") // specify the foreign key column name
    private Student student;


}

