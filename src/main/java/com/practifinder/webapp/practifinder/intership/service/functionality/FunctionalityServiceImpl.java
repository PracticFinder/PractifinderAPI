package com.practifinder.webapp.practifinder.intership.service.functionality;

import com.practifinder.webapp.practifinder.intership.domain.functionality.model.Functionality;
import com.practifinder.webapp.practifinder.intership.domain.functionality.persistence.FunctionalityRepository;
import com.practifinder.webapp.practifinder.intership.domain.functionality.service.FunctionalityService;
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
public class FunctionalityServiceImpl implements FunctionalityService {
    private static final String ENTITY = "Functionality";
    private final FunctionalityRepository functionalityRepository;

    private final Validator validator;

    public FunctionalityServiceImpl(FunctionalityRepository functionalityRepository, Validator validator){
        this.functionalityRepository = functionalityRepository;
        this.validator = validator;
    }

    @Override
    public List<Functionality> getAll(){
        return functionalityRepository.findAll();
    }

    @Override
    public Page<Functionality> getAll(Pageable pageable) {
        return functionalityRepository.findAll(pageable);
    }

    @Override
    public Functionality getById(Long functionalityId) {
        return functionalityRepository.findById(functionalityId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, functionalityId));
    }

    @Override
    public Functionality create(Functionality functionality){
        Set<ConstraintViolation<Functionality>> violations = validator.validate(functionality);

        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY, violations);
        }
        return functionalityRepository.save(functionality);
    }

    @Override
    public Functionality update(Long id, Functionality functionality) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return functionalityRepository.findById(id)
                .map(functionality -> {
                    functionalityRepository.delete(functionality);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

}
