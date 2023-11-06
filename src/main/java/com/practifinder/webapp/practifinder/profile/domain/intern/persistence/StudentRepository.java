package com.practifinder.webapp.practifinder.profile.domain.intern.persistence;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.skill.model.Skill;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Experience> findExperiencesById(Long id);

    List<Skill> findSkillsById(Long id);

    List<Knowledge> findKnowledgesById(Long id);

    List<Language> findLanguagesById(Long id);
    Student findByEmail(String email);

}
