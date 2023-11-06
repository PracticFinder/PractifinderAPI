package com.practifinder.webapp.practifinder.intership.domain.offer.persistence;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntership;
import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntershipStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OfferIntershipStudentRepository extends JpaRepository<OfferIntershipStudent, Long> {
    List<OfferIntershipStudent> findAllByStudentId(Long studentId);
    List<OfferIntershipStudent> findAllByOfferIntership(Optional<OfferIntership> offerIntership);
}
