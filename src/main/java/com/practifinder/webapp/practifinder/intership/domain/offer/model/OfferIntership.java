package com.practifinder.webapp.practifinder.intership.domain.offer.model;

import com.practifinder.webapp.practifinder.intership.domain.benefits.model.Benefits;
import com.practifinder.webapp.practifinder.intership.domain.functionality.model.Functionality;
import com.practifinder.webapp.practifinder.intership.domain.requirement.model.Requirement;
import com.practifinder.webapp.practifinder.profile.domain.business.model.Business;
import com.practifinder.webapp.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "offer_intership")
public class OfferIntership extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String title;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String description;

    @NotNull
    @NotBlank
    private Date dateInit;

    @NotNull
    @NotBlank
    private Date dateEnd;

    @NotNull
    @NotBlank
    @Size(max = 80)
    private String location;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id")
    private Business business;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "offerIntership")
    private Set<Benefits> benefitsListByOfferIntership;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "offerIntership")
    private Set<Requirement> requirementsListByOfferIntership;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "offerIntership")
    private Set<Functionality> functionalitiesListByOfferIntership;

    public void addBenefits(Benefits benefits) {
        if (this.benefitsListByOfferIntership == null) {
            this.benefitsListByOfferIntership = new HashSet<>();
        }
        this.benefitsListByOfferIntership.add(benefits);
    }

    public void addRequirement(Requirement requirement) {
        if (this.requirementsListByOfferIntership == null) {
            this.requirementsListByOfferIntership = new HashSet<>();
        }
        this.requirementsListByOfferIntership.add(requirement);
    }

    public void addFunctionality(Functionality functionality) {
        if (this.functionalitiesListByOfferIntership == null) {
            this.functionalitiesListByOfferIntership = new HashSet<>();
        }
        this.functionalitiesListByOfferIntership.add(functionality);
    }


}
