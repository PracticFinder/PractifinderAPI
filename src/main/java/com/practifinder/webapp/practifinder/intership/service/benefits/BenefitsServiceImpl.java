package com.practifinder.webapp.practifinder.intership.service.benefits;

import com.practifinder.webapp.practifinder.intership.domain.benefits.model.Benefits;
import com.practifinder.webapp.practifinder.intership.domain.benefits.persistence.BenefitsRepository;
import com.practifinder.webapp.practifinder.intership.domain.benefits.service.BenefitsService;
import com.practifinder.webapp.shared.exception.ResourceNotFoundException;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenefitsServiceImpl implements BenefitsService {
    private static final String ENTITY = "Benefits";
    private final BenefitsRepository benefitsRepository;
    private final Validator validator;

    public BenefitsServiceImpl(BenefitsRepository benefitsRepository, Validator validator){
        this.benefitsRepository = benefitsRepository;
        this.validator = validator;
    }

    @Override
    public List<Benefits> getAll(){
        return benefitsRepository.findAll();
    }

    @Override
    public Page<Benefits> getAll(Pageable pageable) {
        return benefitsRepository.findAll(pageable);
    }

    @Override
    public Benefits getById(Long benefitsId) {
        return benefitsRepository.findById(benefitsId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, benefitsId));
    }

    @Override
    public Benefits create(Benefits benefits){
        return benefitsRepository.save(benefits);
    }

    @Override
    public Benefits update(Long id, Benefits benefits) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return benefitsRepository.findById(id)
                .map(benefits -> {
                    benefitsRepository.delete(benefits);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, id));
    }

}
