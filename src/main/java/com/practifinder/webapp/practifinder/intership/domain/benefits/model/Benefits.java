package com.practifinder.webapp.practifinder.intership.domain.benefits.model;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntership;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="benefits")
public class Benefits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max=255)
    private String description;

    @NotNull
    @NotBlank
    private Double salary;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "offer_intership_id", nullable = false)
    private OfferIntership offerIntership;


}
