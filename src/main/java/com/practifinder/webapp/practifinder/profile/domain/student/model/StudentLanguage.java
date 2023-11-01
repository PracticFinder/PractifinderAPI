package com.practifinder.webapp.practifinder.profile.domain.student.model;
import com.practifinder.webapp.practifinder.lifescape.domain.skill.model.Skill;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name="StudentLanguage")
public class StudentLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Skill language;
}
