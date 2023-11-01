package com.practifinder.webapp.practifinder.profile.service.student;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.skill.model.Skill;
import com.practifinder.webapp.practifinder.profile.domain.student.model.Student;
import com.practifinder.webapp.practifinder.profile.domain.student.persistence.StudentRepository;
import com.practifinder.webapp.practifinder.profile.domain.student.service.StudentService;
import com.practifinder.webapp.shared.exception.ResourceNotFoundException;
import com.practifinder.webapp.shared.exception.ResourceValidationException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class StudentServicesImpl implements StudentService {
    private static final String ENTITY = "Student";
    private final Validator validator;
    private final StudentRepository studentRepository;

    public StudentServicesImpl(StudentRepository studentRepository, Validator validator) {
        this.studentRepository = studentRepository;
        this.validator = validator;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> getAll(Pageable pageable) {

        return studentRepository.findAll(pageable);
    }

    @Override
    public Student getById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, studentId));
    }

    @Override
    public Student create(Student student) {
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return studentRepository.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAge(student.getAge());
        existingStudent.setProfileImg(student.getProfileImg());

        Set<ConstraintViolation<Student>> violations = validator.validate(existingStudent);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return studentRepository.save(existingStudent);
    }

    @Override
    public ResponseEntity<?> delete(Long studentId) {
        return studentRepository.findById(studentId).map(payment ->{
                    studentRepository.delete(payment);
                    return ResponseEntity.ok().build();})
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,studentId));
    }

    @Override
    public List<Experience> getExperiencesByStudentId(Long studentId){
        List<Experience> experiences = studentRepository.findExperiencesByApplicantId(studentId);
        if (experiences == null || experiences.isEmpty()) {
            throw new EntityNotFoundException("Experiences not found for student with ID: " + studentId);
        }
        return experiences;
    }

    @Override
    public List<Skill> getSkillsByStudentId(Long studentId) {
        List<Skill> skills = studentRepository.findSkillsByApplicantId(studentId);
        if (skills == null || skills.isEmpty()) {
            throw new EntityNotFoundException("Skills not found for student with ID: " + studentId);
        }
        return skills;
    }

    @Override
    public List<Language> getLanguagesByStudentId(Long studentId) {
        List<Language> languages = studentRepository.findLanguagesByApplicantId(studentId);
        if (languages == null || languages.isEmpty()) {
            throw new EntityNotFoundException("Languages not found for student with ID: " + studentId);
        }
        return languages;
    }
}
