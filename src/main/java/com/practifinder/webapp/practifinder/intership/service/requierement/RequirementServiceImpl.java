package com.practifinder.webapp.practifinder.intership.service.requierement;

import com.practifinder.webapp.practifinder.intership.domain.requirement.model.Requirement;
import com.practifinder.webapp.practifinder.intership.domain.requirement.persistence.RequirementRepository;
import com.practifinder.webapp.practifinder.intership.domain.requirement.service.RequirementService;
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
public class RequirementServiceImpl implements RequirementService {
    private static final String ENTITY = "Requirement";
    private final RequirementRepository requirementRepository;

    private final Validator validator;

    public RequirementServiceImpl(RequirementRepository requirementRepository, Validator validator){
        this.requirementRepository = requirementRepository;
        this.validator = validator;
    }

    @Override
    public List<Requirement> getAll(){
        return requirementRepository.findAll();
    }

    @Override
    public Page<Requirement> getAll(Pageable pageable) {
        return requirementRepository.findAll(pageable);
    }

    @Override
    public Requirement getById(Long requirementId) {
        return requirementRepository.findById(requirementId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, requirementId));
    }

    @Override
    public Requirement create(Requirement requirement){
        Set<ConstraintViolation<Requirement>> violations = validator.validate(requirement);

        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY, violations);
        }

        return requirementRepository.save(requirement);
    }

    @Override
    public Requirement update(Long id, Requirement requirement) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return requirementRepository.findById(id)
                .map(requirement -> {
                    requirementRepository.delete(requirement);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, id));
    }

}
