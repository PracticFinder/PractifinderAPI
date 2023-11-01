package com.practifinder.webapp.practifinder.profile.domain.student.persistence;
import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.skill.model.Skill;
import com.practifinder.webapp.practifinder.profile.domain.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{
    List<Experience> findExperiencesByApplicantId(Long applicantId);
    List<Skill> findSkillsByApplicantId(Long applicantId);
    List<Language> findLanguagesByApplicantId(Long applicantId);
    List<Knowledge> findKnowledgesByApplicantId(Long applicantId);
}
