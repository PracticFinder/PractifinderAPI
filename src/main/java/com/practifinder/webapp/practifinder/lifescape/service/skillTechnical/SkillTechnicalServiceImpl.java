package com.practifinder.webapp.practifinder.lifescape.service.skillTechnical;

import com.practifinder.webapp.practifinder.lifescape.domain.skillTechnical.model.SkillTechnical;
import com.practifinder.webapp.practifinder.lifescape.domain.skillTechnical.repository.SkillTechnicalRepository;
import com.practifinder.webapp.practifinder.lifescape.domain.skillTechnical.service.SkillTechnicalService;
import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.model.SkillInterpersonal;
import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.persistence.SkillInterpersonalRepository;
import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.service.SkillInterpersonalService;
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
public class SkillTechnicalServiceImpl implements SkillTechnicalService {

    private static final String ENTITY="Skill";
    private final SkillTechnicalRepository skillTechnicalRepository;
    private final Validator validator;

    public SkillTechnicalServiceImpl(SkillTechnicalRepository skillTechnicalRepository, Validator validator){
        this.skillTechnicalRepository = skillTechnicalRepository;
        this.validator = validator;
    }

    @Override
    public List<SkillTechnical> getAll(){
        return skillTechnicalRepository.findAll();
    }

    @Override
    public Page<SkillTechnical> getAll(Pageable pageable) {
        return skillTechnicalRepository.findAll(pageable);
    }

    @Override
    public SkillTechnical getById(Long skillId) {
        return skillTechnicalRepository.findById(skillId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, skillId));
    }

    @Override
    public SkillTechnical create(SkillTechnical skillTechnical){
        Set<ConstraintViolation<SkillTechnical>> violations = validator.validate(skillTechnical);

        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY, violations);
        }
        return skillTechnicalRepository.save(skillTechnical);
    }

    @Override
    public SkillTechnical update(Long id, SkillTechnical skillTechnical) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long skillId) {
        return skillTechnicalRepository.findById(skillId).map(skill ->{
                    skillTechnicalRepository.delete(skill);
                    return ResponseEntity.ok().build();})
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,skillId));
    }

    @Override
    public List<SkillTechnical> getByStudentId(Long studentId) {
        return skillTechnicalRepository.findByStudentId(studentId);
    }

}
