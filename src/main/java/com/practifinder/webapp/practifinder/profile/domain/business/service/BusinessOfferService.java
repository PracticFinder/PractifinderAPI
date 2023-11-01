package com.practifinder.webapp.practifinder.profile.domain.business.service;

import com.practifinder.webapp.practifinder.profile.domain.business.model.BusinessOffer;

import java.util.List;

public interface BusinessOfferService {
    List<BusinessOffer> getAll();

    List<BusinessOffer> getAllByBusinessId(Long businessId);

}
