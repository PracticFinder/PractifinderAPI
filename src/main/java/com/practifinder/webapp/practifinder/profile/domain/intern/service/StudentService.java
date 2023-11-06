package com.practifinder.webapp.practifinder.profile.domain.intern.service;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.skill.model.Skill;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Page<Student> getAll(Pageable pageable);
    Student getById(Long paymentId);
    Student create(Student student);
    Student update(Long id, Student student);
    ResponseEntity<?> delete(Long paymentId);

    List<Experience> getExperiencesByStudentId(Long studentId);

    List<Skill> getSkillsByStudentId(Long studentId);

    List<Language> getLanguagesByStudentId(Long studentId);

    List<Knowledge> getKnowledgesByStudentId(Long studentId);

}
