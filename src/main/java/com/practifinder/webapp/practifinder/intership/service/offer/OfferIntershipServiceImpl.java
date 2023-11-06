package com.practifinder.webapp.practifinder.intership.service.offer;

import com.practifinder.webapp.practifinder.intership.domain.benefits.model.Benefits;
import com.practifinder.webapp.practifinder.intership.domain.functionality.model.Functionality;
import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntership;
import com.practifinder.webapp.practifinder.intership.domain.offer.persistence.OfferIntershipRepository;
import com.practifinder.webapp.practifinder.intership.domain.offer.service.OfferIntershipService;
import com.practifinder.webapp.practifinder.intership.domain.requirement.model.Requirement;
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
public class OfferIntershipServiceImpl implements OfferIntershipService {
    private static final String ENTITY = "OfferInternship";
    private final OfferIntershipRepository offerIntershipRepository;

    private final Validator validator;

    public OfferIntershipServiceImpl(OfferIntershipRepository offerIntershipRepository, Validator validator){
        this.offerIntershipRepository = offerIntershipRepository;
        this.validator = validator;
    }

    @Override
    public List<OfferIntership> getAll() {
        return offerIntershipRepository.findAll();
    }

    @Override
    public Page<OfferIntership> getAll(Pageable pageable) {
        return offerIntershipRepository.findAll(pageable);
    }

    @Override
    public OfferIntership getById(Long offerIntershipId) {
        return offerIntershipRepository.findById(offerIntershipId).orElseThrow(()-> new ResourceNotFoundException(ENTITY, offerIntershipId));
    }

    @Override
    public OfferIntership create(OfferIntership offerIntership) {
        Set<ConstraintViolation<OfferIntership>> violations = validator.validate(offerIntership);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        OfferIntership offerIntershipWithTitle = offerIntershipRepository.findByTitle(offerIntership.getTitle());

        if (offerIntershipWithTitle != null)
            throw new ResourceValidationException(ENTITY, "title already exists");

        return offerIntershipRepository.save(offerIntership);
    }

    @Override
    public OfferIntership update(Long offerIntershipId, OfferIntership offerIntership) {
        Set<ConstraintViolation<OfferIntership>> violations = validator.validate(offerIntership);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        OfferIntership offerIntershipWithTitle = offerIntershipRepository.findByTitle(offerIntership.getTitle());

        if (offerIntershipWithTitle != null && !offerIntershipWithTitle.getId().equals(offerIntershipId))
            throw new ResourceValidationException(ENTITY, "title already exists");

        return offerIntershipRepository.findById(offerIntershipId)
                .map(offerIntershipToUpdate -> {
                    offerIntershipToUpdate.setTitle(offerIntership.getTitle());
                    offerIntershipToUpdate.setDescription(offerIntership.getDescription());
                    offerIntershipToUpdate.setDateInit(offerIntership.getDateInit());
                    offerIntershipToUpdate.setDateEnd(offerIntership.getDateEnd());
                    offerIntershipToUpdate.setLocation(offerIntership.getLocation());
                    return offerIntershipRepository.save(offerIntershipToUpdate);
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, offerIntershipId));
    }

    @Override
    public ResponseEntity<?> delete(Long offerIntershipId) {
        return offerIntershipRepository.findById(offerIntershipId)
                .map(offerIntership -> {
                    offerIntershipRepository.delete(offerIntership);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, offerIntershipId));
    }

    @Override
    public OfferIntership addBenefits(Long offerIntershipId, Benefits benefits) {
        OfferIntership offerIntership = offerIntershipRepository.findById(offerIntershipId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, offerIntershipId));
        offerIntership.addBenefits(benefits);
        return offerIntershipRepository.save(offerIntership);
    }

    @Override
    public OfferIntership addRequirement(Long offerIntershipId, Requirement requirement) {
        OfferIntership offerIntership = offerIntershipRepository.findById(offerIntershipId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, offerIntershipId));
        offerIntership.addRequirement(requirement);
        return offerIntershipRepository.save(offerIntership);
    }

    @Override
    public OfferIntership addFunctionality(Long offerIntershipId, Functionality functionality) {
        OfferIntership offerIntership = offerIntershipRepository.findById(offerIntershipId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, offerIntershipId));
        offerIntership.addFunctionality(functionality);
        return offerIntershipRepository.save(offerIntership);
    }

}
