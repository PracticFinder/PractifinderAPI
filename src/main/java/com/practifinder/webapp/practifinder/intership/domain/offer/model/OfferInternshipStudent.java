package com.practifinder.webapp.practifinder.intership.domain.offer.model;


import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "offer_student")
public class OfferInternshipStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private OfferInternship offer;


}
