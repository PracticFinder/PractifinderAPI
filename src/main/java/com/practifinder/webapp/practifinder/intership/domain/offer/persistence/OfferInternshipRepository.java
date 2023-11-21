package com.practifinder.webapp.practifinder.intership.domain.offer.persistence;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferInternshipRepository extends JpaRepository<OfferInternship, Long> {
    OfferInternship findByTitulo(String titulo);

}
