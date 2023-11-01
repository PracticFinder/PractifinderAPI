package com.practifinder.webapp.practifinder.lifescape.service.skill;

import com.practifinder.webapp.practifinder.lifescape.domain.skill.model.Skill;
import com.practifinder.webapp.practifinder.lifescape.domain.skill.persistence.SkillRepository;
import com.practifinder.webapp.practifinder.lifescape.domain.skill.service.SkillService;
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
public class SkillServiceImpl implements SkillService {
    private static final String ENTITY="Skill";
    private final SkillRepository skillRepository;
    private final Validator validator;

    public SkillServiceImpl(SkillRepository skillRepository, Validator validator){
        this.skillRepository = skillRepository;
        this.validator = validator;
    }

    @Override
    public List<Skill> getAll(){
        return skillRepository.findAll();
    }

    @Override
    public Page<Skill> getAll(Pageable pageable) {
        return skillRepository.findAll(pageable);
    }

    @Override
    public Skill getById(Long skillId) {
        return skillRepository.findById(skillId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, skillId));
    }

    @Override
    public Skill create(Skill skill){
        Set<ConstraintViolation<Skill>> violations = validator.validate(skill);

        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY, violations);
        }
        return skillRepository.save(skill);
    }

    @Override
    public Skill update(Long id, Skill skill) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long skillId) {
        return skillRepository.findById(skillId).map(skill ->{
                    skillRepository.delete(skill);
                    return ResponseEntity.ok().build();})
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,skillId));
    }

}
