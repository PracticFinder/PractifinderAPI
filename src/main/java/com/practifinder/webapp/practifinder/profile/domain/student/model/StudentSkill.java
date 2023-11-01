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
@Table(name="StudentSkill")
public class StudentSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

}
