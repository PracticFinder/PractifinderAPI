package com.practifinder.webapp.practifinder.profile.service.intern;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.model.SkillInterpersonal;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import com.practifinder.webapp.practifinder.profile.domain.intern.persistence.StudentRepository;
import com.practifinder.webapp.practifinder.profile.domain.intern.service.StudentService;
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
public class StudentServiceImpl implements StudentService {
    private static final String ENTITY = "Student";
    private final Validator validator;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository, Validator validator) {
        this.studentRepository= studentRepository;
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
    public Student getById(Long paymentId) {
        return studentRepository.findById(paymentId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, paymentId));
    }

    @Override
    public Student create(Student student) {
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Student studentWithEmail = studentRepository.findByCorreo(student.getCorreo());

        if(studentWithEmail != null)
            throw new ResourceValidationException(ENTITY,
                    "A student with the same email already exists.");

        return studentRepository.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Student studentWithEmail = studentRepository.findByCorreo(student.getCorreo());

        if(studentWithEmail != null && !studentWithEmail.getId().equals(id))
            throw new ResourceValidationException(ENTITY,
                    "A student with the same email already exists.");

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));

        existingStudent.setNombre(student.getNombre());
        existingStudent.setCorreo(student.getCorreo());
        existingStudent.setEdad(student.getEdad());
        existingStudent.setImagen(student.getImagen());


        return studentRepository.save(existingStudent);
    }

    @Override
    public ResponseEntity<?> delete(Long studentId) {
        return studentRepository.findById(studentId).map(student ->{
                    studentRepository.delete(student);
                    return ResponseEntity.ok().build();})
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,studentId));
    }

    @Override
    public List<Experience> getExperiencesByStudentId(Long studentId){
        List<Experience> experiences = studentRepository.findExperiencesById(studentId);
        if (experiences == null || experiences.isEmpty()) {
            throw new EntityNotFoundException("Experiences not found for student with ID: " + studentId);
        }
        return experiences;
    }
    @Override
    public List<SkillInterpersonal> getSkillsByStudentId(Long studentId) {
        return null;
    }

    @Override
    public List<Language> getLanguagesByStudentId(Long studentId) {
        return null;
    }

    @Override
    public List<Knowledge> getKnowledgesByStudentId(Long studentId) {
        return null;
    }


}