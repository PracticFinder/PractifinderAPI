package com.practifinder.webapp.practifinder.intership.domain.offer.service;

import com.practifinder.webapp.practifinder.intership.domain.benefits.model.Benefits;
import com.practifinder.webapp.practifinder.intership.domain.functionality.model.Functionality;
import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntership;
import com.practifinder.webapp.practifinder.intership.domain.requirement.model.Requirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OfferIntershipService {
    List<OfferIntership> getAll();
    Page<OfferIntership> getAll(Pageable pageable);
    OfferIntership getById(Long offerIntershipId);
    OfferIntership create(OfferIntership offerIntership);
    OfferIntership update(Long offerIntershipId, OfferIntership offerIntership);
    ResponseEntity<?> delete(Long offerIntershipId);
    public OfferIntership addBenefits(Long offerIntershipId, Benefits benefits);
    public OfferIntership addFunctionality(Long offerIntershipId, Functionality functionality);
    public OfferIntership addRequirement(Long offerIntershipId, Requirement requirement);
}
