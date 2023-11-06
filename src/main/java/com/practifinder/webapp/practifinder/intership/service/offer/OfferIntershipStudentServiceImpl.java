package com.practifinder.webapp.practifinder.intership.service.offer;


import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntership;
import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntershipStudent;
import com.practifinder.webapp.practifinder.intership.domain.offer.persistence.OfferIntershipRepository;
import com.practifinder.webapp.practifinder.intership.domain.offer.persistence.OfferIntershipStudentRepository;
import com.practifinder.webapp.practifinder.intership.domain.offer.service.OfferIntershipStudentService;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferIntershipStudentServiceImpl implements OfferIntershipStudentService {

    private static final String ENTITY = "OfferIntershipStudent";

    private final OfferIntershipStudentRepository offerIntershipStudentRepository;

    private final OfferIntershipRepository offerIntershipRepository;

    private final Validator validator;

    public OfferIntershipStudentServiceImpl(OfferIntershipStudentRepository offerIntershipStudentRepository, OfferIntershipRepository offerIntershipRepository, Validator validator){
        this.offerIntershipStudentRepository = offerIntershipStudentRepository;
        this.offerIntershipRepository = offerIntershipRepository;
        this.validator = validator;
    }


    @Override
    public List<OfferIntershipStudent> getAll() {
        return offerIntershipStudentRepository.findAll();
    }

    @Override
    public OfferIntershipStudent create(OfferIntershipStudent offerIntershipStudent) {
        return null;
    }

    @Override
    public OfferIntershipStudent update(OfferIntershipStudent offerIntershipStudent) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long offerIntershipStudentId) {
        return null;
    }

    @Override
    public List<OfferIntershipStudent> getAllByStudentId(Long studentId) {
        return offerIntershipStudentRepository.findAllByStudentId(studentId);
    }

    @Override
    public List<OfferIntershipStudent> getAllStudentsByOfferIntershipId(Long offerIntershipId) {
        var offerIntership = offerIntershipRepository.findById(offerIntershipId).orElse(null);
        if(offerIntership == null){
           throw new RuntimeException("Offer Internship not found");
        }
        return offerIntershipStudentRepository.findAllByOfferIntership(Optional.of(offerIntership));
    }
}
