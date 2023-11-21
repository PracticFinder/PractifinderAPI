package com.practifinder.webapp.practifinder.lifescape.domain.language.model;

import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import com.practifinder.webapp.shared.domain.model.AuditModel;
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
@Table(name="language")
public class Language extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max=20)
    @Column(name = "nivel")
    private String nivel;

    @NotNull
    @NotBlank
    @Size(max=200)
    @Column(name = "idioma", unique = true)
    private String idioma;

    @ManyToOne
    @JoinColumn(name = "student_id") // specify the foreign key column name
    private Student student;
}