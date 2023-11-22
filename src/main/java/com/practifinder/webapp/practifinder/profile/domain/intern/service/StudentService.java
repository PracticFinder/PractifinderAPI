package com.practifinder.webapp.practifinder.profile.domain.intern.service;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.skillTechnical.model.SkillTechnical;
import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.model.SkillInterpersonal;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import com.practifinder.webapp.practifinder.profile.resource.intern.CreateStudentWithAttributesResource;
import com.practifinder.webapp.practifinder.profile.resource.intern.StudentResource;
import com.practifinder.webapp.security.domain.service.communication.RegisterRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Page<Student> getAll(Pageable pageable);
    Student getById(Long studentId);
    Student create(Student student);
    Student update(Long id, Student student);
    ResponseEntity<?> delete(Long studentId);

    List<Experience> getExperiencesByStudentId(Long studentId);
    List<Knowledge> getKnowledgesByStudentId(Long studentId);
    List<Language> getLanguagesByStudentId(Long studentId);
    List<SkillInterpersonal> getSkillsInterpersonalByStudentId(Long studentId);
    List<SkillTechnical> getSkillsTechnicalByStudentId(Long studentId);
    Student createWithMissingAttributes(Long studentId, CreateStudentWithAttributesResource createStudentWithAttributesResource);

    List<Experience> addExperienceToStudent(Long studentId, Experience experience);

    List<SkillInterpersonal> addSkillInterpersonalToStudent(Long studentId, SkillInterpersonal skillInterpersonal);

    List<SkillTechnical> addSkillTechnicalToStudent(Long studentId, SkillTechnical skillTechnical);

    List<Knowledge> addKnowledgeToStudent(Long studentId, Knowledge knowledge);

    List<Language> addLanguageToStudent(Long studentId, Language language);

    List<StudentResource> getAllStudentOffers();

}
