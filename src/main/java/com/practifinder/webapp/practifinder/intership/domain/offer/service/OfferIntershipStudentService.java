package com.practifinder.webapp.practifinder.intership.domain.offer.service;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntershipStudent;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OfferIntershipStudentService {
    List<OfferIntershipStudent> getAll();
    OfferIntershipStudent create(OfferIntershipStudent offerIntershipStudent);
    OfferIntershipStudent update(OfferIntershipStudent offerIntershipStudent);
    ResponseEntity<?> delete(Long offerIntershipStudentId);
    List<OfferIntershipStudent> getAllByStudentId(Long studentId);
    List<OfferIntershipStudent> getAllStudentsByOfferIntershipId(Long offerIntershipId);

}
