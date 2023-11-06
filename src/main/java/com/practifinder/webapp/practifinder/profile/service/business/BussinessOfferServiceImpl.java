package com.practifinder.webapp.practifinder.profile.service.business;

import com.practifinder.webapp.practifinder.profile.domain.business.model.BusinessOffer;
import com.practifinder.webapp.practifinder.profile.domain.business.persistence.BusinessOfferRepository;
import com.practifinder.webapp.practifinder.profile.domain.business.persistence.BusinessRepository;
import com.practifinder.webapp.practifinder.profile.domain.business.service.BusinessOfferService;
import com.practifinder.webapp.shared.exception.ResourceValidationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BussinessOfferServiceImpl implements BusinessOfferService {

    private final BusinessOfferRepository businessOfferRepository;
    private final BusinessRepository businessRepository;

    public BussinessOfferServiceImpl(BusinessOfferRepository businessOfferRepository, BusinessRepository businessRepository) {
        this.businessOfferRepository = businessOfferRepository;
        this.businessRepository = businessRepository;
    }

    @Override
    public List<BusinessOffer> getAll() {
        return businessOfferRepository.findAll();
    }

    @Override
    public List<BusinessOffer> getAllByBusinessId(Long businessId) {
        var business=businessRepository.findById(businessId);
        if(business==null) throw new ResourceValidationException("The business doesn't exist.");
        return businessOfferRepository.findAllByBusinessId(businessId);
    }
}
