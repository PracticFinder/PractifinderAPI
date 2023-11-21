package com.practifinder.webapp.practifinder.intership.domain.offer.persistence;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OfferInternshipRepository extends JpaRepository<OfferInternship, Long> {
    OfferInternship findByTitulo(String titulo);

    @Query("SELECT o FROM OfferInternship o LEFT JOIN FETCH o.postulantes WHERE o.id = :offerId")
    OfferInternship findByIdWithPostulantes(@Param("offerId") Long offerId);

}
