package com.practifinder.webapp.practifinder.intership.service.offer;


import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import com.practifinder.webapp.practifinder.intership.domain.offer.persistence.OfferInternshipRepository;
import com.practifinder.webapp.practifinder.intership.domain.offer.service.OfferInternshipService;
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
public class OfferInternshipServiceImpl implements OfferInternshipService {
    private static final String ENTITY = "OfferInternship";
    private final OfferInternshipRepository offerInternshipRepository;

    private final Validator validator;

    public OfferInternshipServiceImpl(OfferInternshipRepository offerInternshipRepository, Validator validator){
        this.offerInternshipRepository = offerInternshipRepository;
        this.validator = validator;
    }

    @Override
    public List<OfferInternship> getAll() {
        return offerInternshipRepository.findAll();
    }

    @Override
    public Page<OfferInternship> getAll(Pageable pageable) {
        return offerInternshipRepository.findAll(pageable);
    }

    @Override
    public OfferInternship getById(Long offerInternshipId) {
        return offerInternshipRepository.findById(offerInternshipId).orElseThrow(()-> new ResourceNotFoundException(ENTITY, offerInternshipId));
    }

    @Override
    public OfferInternship create(OfferInternship offerInternship) {
        Set<ConstraintViolation<OfferInternship>> violations = validator.validate(offerInternship);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        OfferInternship offerInternshipWithTitle = offerInternshipRepository.findByTitulo(offerInternship.getTitulo());

        if (offerInternshipWithTitle != null)
            throw new ResourceValidationException(ENTITY, "title already exists");

        return offerInternshipRepository.save(offerInternship);
    }

    @Override
    public OfferInternship update(Long offerInternshipId, OfferInternship offerInternship) {
        Set<ConstraintViolation<OfferInternship>> violations = validator.validate(offerInternship);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        OfferInternship offerInternshipWithTitle = offerInternshipRepository.findByTitulo(offerInternship.getTitulo());

        if (offerInternshipWithTitle != null && !offerInternshipWithTitle.getId().equals(offerInternshipId))
            throw new ResourceValidationException(ENTITY, "title already exists");

        return offerInternshipRepository.findById(offerInternshipId)
                .map(offerInternshipToUpdate -> {
                    offerInternshipToUpdate.setTitulo(offerInternship.getTitulo());
                    offerInternshipToUpdate.setDescripcion(offerInternship.getDescripcion());
                    offerInternshipToUpdate.setFechaInicio(offerInternship.getFechaInicio());
                    offerInternshipToUpdate.setFechaFin(offerInternship.getFechaFin());
                    offerInternshipToUpdate.setRequisitos(offerInternship.getRequisitos());
                    offerInternshipToUpdate.setFunciones(offerInternship.getFunciones());
                    offerInternshipToUpdate.setBeneficios(offerInternship.getBeneficios());
                    offerInternshipToUpdate.setMore(offerInternship.getMore());
                    offerInternshipToUpdate.setArea(offerInternship.getArea());
                    offerInternshipToUpdate.setUbicacion(offerInternship.getUbicacion());
                    offerInternshipToUpdate.setSalario(offerInternship.getSalario());
                    return offerInternshipRepository.save(offerInternshipToUpdate);
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, offerInternshipId));
    }

    @Override
    public ResponseEntity<?> delete(Long offerInternshipId) {
        return offerInternshipRepository.findById(offerInternshipId)
                .map(offerInternship -> {
                    offerInternshipRepository.delete(offerInternship);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, offerInternshipId));
    }


}
