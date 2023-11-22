package com.practifinder.webapp.practifinder.intership.domain.offer.service;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternshipStudent;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import com.practifinder.webapp.practifinder.profile.resource.intern.StudentResource;

import java.util.List;

public interface OfferInternshipStudentService {
    List<Student> getPostulantes(Long offerId);

    List<OfferInternship> getPostulaciones(Long studentId);

    void registerStudentForOffer(Long offerId, Long studentId);

    OfferInternship getOffer(Long offerId, Long studentId);

    StudentResource getStudent(Long offerId, Long studentId);

    List<Student> getPostulantes(List<OfferInternshipStudent> lista);

    List<OfferInternship> getPostulaciones(List<OfferInternshipStudent> lista);
}
