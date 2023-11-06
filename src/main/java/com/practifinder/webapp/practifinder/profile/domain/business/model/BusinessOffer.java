package com.practifinder.webapp.practifinder.profile.domain.business.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name="business_offers")
public class BusinessOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "business_id",nullable = false)
    @JsonIgnore
    private Business business;

    private Long offerId;

    public BusinessOffer(Business business, Long offerId) {
        this.business = business;
        this.offerId = offerId;
    }
}
