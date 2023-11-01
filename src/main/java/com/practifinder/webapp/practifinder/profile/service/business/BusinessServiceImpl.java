package com.practifinder.webapp.practifinder.profile.service.business;

import com.practifinder.webapp.practifinder.profile.domain.business.model.Business;
import com.practifinder.webapp.practifinder.profile.domain.business.persistence.BusinessRepository;
import com.practifinder.webapp.practifinder.profile.domain.business.service.BusinessService;
import com.practifinder.webapp.shared.exception.ResourceNotFoundException;
import com.practifinder.webapp.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BusinessServiceImpl implements BusinessService {
    private static final String ENTITY  = "Business";

    private final Validator validator;
    private final BusinessRepository businessRepository;

    public BusinessServiceImpl(BusinessRepository businessRepository, Validator validator) {
        this.businessRepository = businessRepository;
        this.validator = validator;
    }


    @Override
    public List<Business> getAll() {
        return businessRepository.findAll();
    }

    @Override
    public Business getById(Long businessId) {
        return businessRepository.findById(businessId).orElseThrow(()->new ResourceNotFoundException(ENTITY,businessId));
    }

    @Override
    public Page<Business> getAll(Pageable pageable) {
        return businessRepository.findAll(pageable);
    }

    @Override
    public Business create(Business business) {
        //Constraints validation
        Set<ConstraintViolation<Business>> violations=validator.validate(business);

        if(!violations.isEmpty()){ //si hay alguna violacion
            throw new ResourceValidationException(ENTITY,violations);
        }

        Business businessWithEmail=businessRepository.findFirstByEmail(business.getEmail());

        if(businessWithEmail !=null){
            throw new ResourceValidationException(ENTITY,"The email is already in use.");
        }

        return businessRepository.save(business);
    }

    @Override
    public Business update(Long businessId, Business business) {
        //Constraints validation
        Set<ConstraintViolation<Business>> violations=validator.validate(business);

        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY,violations);
        }

        Business businessToUpdate=businessRepository.findById(businessId).orElseThrow(()->new ResourceNotFoundException(ENTITY,businessId));

        businessToUpdate.setName(business.getName());
        businessToUpdate.setDescription(business.getDescription());
        businessToUpdate.setEmail(business.getEmail());
        businessToUpdate.setLocation(business.getLocation());
        businessToUpdate.setSiteWeb(business.getSiteWeb());

        return businessRepository.save(businessToUpdate);
    }

    @Override
    public ResponseEntity<?> delete(Long businessId) {
        return businessRepository.findById(businessId).map(business -> {
            businessRepository.delete(business);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY,businessId));
    }

    @Override
    public Business addOfferToBusiness(Long businessId, Long offerId) {
        /*return businessRepository.findById(businessId).map(business -> {
            business.addOffer(business,offerId);
            return businessRepository.save(business);
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY,businessId));*/
        return null;
    }


}
