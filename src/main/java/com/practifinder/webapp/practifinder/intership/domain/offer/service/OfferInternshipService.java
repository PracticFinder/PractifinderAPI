package com.practifinder.webapp.practifinder.intership.domain.offer.service;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import com.practifinder.webapp.practifinder.intership.resource.offer.CreateOfferInternshipResource;
import com.practifinder.webapp.practifinder.intership.resource.offer.UpdateOfferInternshipResource;
import com.practifinder.webapp.practifinder.profile.resource.intern.StudentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OfferInternshipService {
    List<OfferInternship> getAll();
    Page<OfferInternship> getAll(Pageable pageable);
    OfferInternship getById(Long offerInternshipId);
    OfferInternship create(CreateOfferInternshipResource offerInternship);

    OfferInternship update(Long offerInternshipId, OfferInternship offerInternship);
    ResponseEntity<?> delete(Long offerInternshipId);

    List<StudentResource> getPostulantesByOfferId(Long offerId);

}
