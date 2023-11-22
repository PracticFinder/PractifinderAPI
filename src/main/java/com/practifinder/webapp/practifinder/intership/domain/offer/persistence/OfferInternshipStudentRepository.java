package com.practifinder.webapp.practifinder.intership.domain.offer.persistence;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternshipStudent;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OfferInternshipStudentRepository extends JpaRepository<OfferInternshipStudent, Long> {
    List<OfferInternshipStudent> findByOffer(OfferInternship offer);

    List<OfferInternshipStudent> findByStudent(Student student);

    @Query("SELECT ois.student FROM OfferInternshipStudent ois WHERE ois.offer.id = :offerId")
    List<Student> findStudentsByOfferId(@Param("offerId") Long offerId);

    @Query("SELECT ois.offer FROM OfferInternshipStudent ois WHERE ois.student.id = :studentId")
    List<OfferInternship> findOffersByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT ois.offer.postulantes FROM OfferInternshipStudent ois WHERE ois.student.id = :studentId")
    List<Student> findPostulantesByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT ois.student.postulaciones FROM OfferInternshipStudent ois WHERE ois.offer.id = :offerId")
    List<OfferInternship> findPostulacionesByOfferId(@Param("offerId") Long offerId);

    @Query("SELECT ois FROM OfferInternshipStudent ois WHERE ois.offer.id = :offerId AND ois.student.id = :studentId")
    OfferInternshipStudent findByOfferIdAndStudentId(@Param("offerId") Long offerId, @Param("studentId") Long studentId);
}
