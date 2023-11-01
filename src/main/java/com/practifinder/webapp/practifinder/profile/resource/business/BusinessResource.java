package com.practifinder.webapp.practifinder.profile.resource.business;

import com.practifinder.webapp.practifinder.profile.domain.business.model.BusinessOffer;

import java.util.Set;

public class BusinessResource {
    private Long id;
    private String name;
    private String email;
    private String location;

    private Set<BusinessOffer> offersListByBusiness;
}
