package com.practifinder.webapp.practifinder.profile.domain.student.model;

import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name="StudentKnowledge")
public class StudentKnowledge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "knowledge_id")
    private Knowledge knowledge;
}
