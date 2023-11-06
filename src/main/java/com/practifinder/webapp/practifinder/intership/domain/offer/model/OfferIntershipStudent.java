package com.practifinder.webapp.practifinder.intership.domain.offer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "offer_intership_student")
public class OfferIntershipStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "offer_intership_id",nullable = false)
    @JsonIgnore
    private OfferIntership offerIntership;

    private Long studentId;

    public OfferIntershipStudent(OfferIntership offerIntership, Long studentId) {
        this.offerIntership = offerIntership;
        this.studentId = studentId;
    }

}
