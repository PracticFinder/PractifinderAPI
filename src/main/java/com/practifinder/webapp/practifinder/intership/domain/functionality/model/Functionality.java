package com.practifinder.webapp.practifinder.intership.domain.functionality.model;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntership;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="functionality")
public class Functionality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "offer_intership_id", nullable = false)
    private OfferIntership offerIntership;
}
