package com.practifinder.webapp.practifinder.intership.domain.offer.service;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OfferInternshipService {
    List<OfferInternship> getAll();
    Page<OfferInternship> getAll(Pageable pageable);
    OfferInternship getById(Long offerInternshipId);
    OfferInternship create(OfferInternship offerInternship);
    OfferInternship update(Long offerInternshipId, OfferInternship offerInternship);
    ResponseEntity<?> delete(Long offerInternshipId);

}
