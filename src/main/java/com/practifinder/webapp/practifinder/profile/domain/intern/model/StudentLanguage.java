package com.practifinder.webapp.practifinder.profile.domain.intern.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name="student_language")
public class StudentLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnore
    private Student student;


    public StudentLanguage(Student student, Long studentId) {
        this.student = student;
    }
}
