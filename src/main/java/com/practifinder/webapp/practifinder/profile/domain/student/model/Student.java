package com.practifinder.webapp.practifinder.profile.domain.student.model;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.skill.model.Skill;
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

    @ManyToMany
    @JoinTable(
            name = "student_skill",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    @ManyToMany
    @JoinTable(
            name = "student_language",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languages;

    @ManyToMany
    @JoinTable(
            name = "student_knowledge",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "knowledge_id")
    )
    private List<Knowledge> knowledge;
}
