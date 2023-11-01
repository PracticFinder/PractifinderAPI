package com.practifinder.webapp.practifinder.profile.domain.business.service;

import com.practifinder.webapp.practifinder.profile.domain.business.model.Business;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BusinessService {
    List<Business> getAll();
    Page<Business> getAll(Pageable pageable);

    Business getById(Long businessId);

    Business create(Business business);

    Business update(Long businessId, Business business);

    ResponseEntity<?> delete(Long businessId);

    Business addOfferToBusiness(Long businessId, Long offerId);


}
