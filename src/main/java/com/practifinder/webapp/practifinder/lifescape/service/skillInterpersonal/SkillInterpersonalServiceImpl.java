package com.practifinder.webapp.practifinder.lifescape.service.skillInterpersonal;

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
public class SkillInterpersonalServiceImpl implements SkillInterpersonalService {
    private static final String ENTITY="Skill";
    private final SkillInterpersonalRepository skillInterpersonalRepository;
    private final Validator validator;

    public SkillInterpersonalServiceImpl(SkillInterpersonalRepository skillInterpersonalRepository, Validator validator){
        this.skillInterpersonalRepository = skillInterpersonalRepository;
        this.validator = validator;
    }

    @Override
    public List<SkillInterpersonal> getAll(){
        return skillInterpersonalRepository.findAll();
    }

    @Override
    public Page<SkillInterpersonal> getAll(Pageable pageable) {
        return skillInterpersonalRepository.findAll(pageable);
    }

    @Override
    public SkillInterpersonal getById(Long skillId) {
        return skillInterpersonalRepository.findById(skillId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, skillId));
    }

    @Override
    public SkillInterpersonal create(SkillInterpersonal skillInterpersonal){
        Set<ConstraintViolation<SkillInterpersonal>> violations = validator.validate(skillInterpersonal);

        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY, violations);
        }
        return skillInterpersonalRepository.save(skillInterpersonal);
    }

    @Override
    public SkillInterpersonal update(Long id, SkillInterpersonal skillInterpersonal) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long skillId) {
        return skillInterpersonalRepository.findById(skillId).map(skill ->{
                    skillInterpersonalRepository.delete(skill);
                    return ResponseEntity.ok().build();})
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,skillId));
    }

}
