package com.practifinder.webapp.practifinder.intership.domain.offer.persistence;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.events.Event;

public interface OfferIntershipRepository extends JpaRepository<OfferIntership, Long> {
    OfferIntership findByTitle(String title);

}
