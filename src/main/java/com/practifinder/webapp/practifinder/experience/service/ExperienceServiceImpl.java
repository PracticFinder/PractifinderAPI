package com.practifinder.webapp.practifinder.experience.service;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.experience.domain.persistence.ExperienceRepository;
import com.practifinder.webapp.practifinder.experience.domain.service.ExperienceService;
import com.practifinder.webapp.practifinder.experience.resource.CreateExperienceResource;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import com.practifinder.webapp.practifinder.profile.domain.intern.service.StudentService;
import com.practifinder.webapp.shared.exception.ResourceNotFoundException;
import com.practifinder.webapp.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    private static final String ENTITY = "Experience";
    private final Validator validator;
    private final ExperienceRepository experienceRepository;

    private final StudentService studentService;

    public ExperienceServiceImpl(ExperienceRepository experienceRepository, Validator validator,
                                 StudentService studentService) {
        this.experienceRepository= experienceRepository;
        this.validator = validator;
        this.studentService = studentService;
    }


    @Override
    public List<Experience> getAll() {
        return experienceRepository.findAll();
    }

    @Override
    public Page<Experience> getAll(Pageable pageable) {
        return experienceRepository.findAll(pageable);
    }

    @Override
    public Experience getById(Long experienceId) {
        return experienceRepository.findById(experienceId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, experienceId));
    }

    @Override
    public Experience create(CreateExperienceResource createExperienceResource) {
        Set<ConstraintViolation<CreateExperienceResource>> violations = validator.validate(createExperienceResource);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Student student = studentService.getById(createExperienceResource.getStudentId());

        Experience experience = new Experience();

        experience.setEmpresa(createExperienceResource.getEmpresa());
        experience.setCargo(createExperienceResource.getCargo());
        experience.setDescripcion(createExperienceResource.getDescripcion());
        experience.setFechaFinalizacion(createExperienceResource.getFechaFinalizacion());
        experience.setFechaInicio(createExperienceResource.getFechaInicio());
        experience.setStudent(student);

        return experienceRepository.save(experience);
    }

    @Override
    public Experience update(Long id, Experience experience) {
        Experience existingExperience = experienceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));

        existingExperience.setEmpresa(experience.getEmpresa());
        existingExperience.setCargo(experience.getCargo());
        existingExperience.setDescripcion(experience.getDescripcion());
        existingExperience.setFechaFinalizacion(experience.getFechaFinalizacion());
        existingExperience.setFechaInicio(experience.getFechaInicio());

        Set<ConstraintViolation<Experience>> violations = validator.validate(existingExperience);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }
        return experienceRepository.save(existingExperience);
    }

    @Override
    public ResponseEntity<?> delete(Long experienceId) {
        return experienceRepository.findById(experienceId).map(payment ->{
                    experienceRepository.delete(payment);
                    return ResponseEntity.ok().build();})
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,experienceId));
    }

    @Override
    public List<Experience> getByStudentId(Long studentId) {
        return experienceRepository.findByStudentId(studentId);
    }
}