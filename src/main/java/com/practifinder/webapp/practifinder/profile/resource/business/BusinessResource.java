package com.practifinder.webapp.practifinder.profile.resource.business;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferInternshipResource;
import lombok.*;

import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class BusinessResource {
    private Long id;
    private String nombre;

    private String username;

    private String password;

    private Long rolId;


    private String location;


    private String imagen;


    private String siteWeb;

    private List<OfferInternshipResource> ofertas;
}
