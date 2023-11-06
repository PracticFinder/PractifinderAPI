package com.practifinder.webapp.practifinder.profile.domain.intern.model;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntership;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.skill.model.Skill;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private String profile_img;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
    private Set<StudentExperience> experiences;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
    private Set<StudentKnowledge> knowledgeListByStudent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
    private Set<StudentLanguage> languageListByStudent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
    private Set<StudentSkill> skillListByStudent;

    public Student addKnowledge(Student student, Long studentId) {
        if (student == null) knowledgeListByStudent = new HashSet<>();
        this.knowledgeListByStudent.add(new StudentKnowledge(this, studentId));
        return this;
    }


    public Student addLanguage(Student student, Long studentId) {
        if (student == null) languageListByStudent = new HashSet<>();
        this.languageListByStudent.add(new StudentLanguage(this, studentId));
        return this;
    }

    public Student addSkill(Student student, Long studentId) {
        if (student == null) skillListByStudent = new HashSet<>();
        this.skillListByStudent.add(new StudentSkill(this, studentId));
        return this;
    }

}
