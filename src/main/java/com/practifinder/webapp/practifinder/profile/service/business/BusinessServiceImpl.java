package com.practifinder.webapp.practifinder.profile.service.business;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import com.practifinder.webapp.practifinder.profile.domain.business.model.Business;
import com.practifinder.webapp.practifinder.profile.domain.business.persistence.BusinessRepository;
import com.practifinder.webapp.practifinder.profile.domain.business.service.BusinessService;
import com.practifinder.webapp.practifinder.profile.resource.business.CreateBusinessWithAttributesResource;
import com.practifinder.webapp.shared.exception.ResourceNotFoundException;
import com.practifinder.webapp.shared.exception.ResourceValidationException;
import jakarta.persistence.EntityNotFoundException;
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

        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY,violations);
        }

        Business businessWithEmail=businessRepository.findFirstByCorreo(business.getCorreo());

        if(businessWithEmail !=null){
            throw new ResourceValidationException(ENTITY,"The email is already in use.");
        }

        if(business.getImagen() == null)
            business.setImagen("https://i.ibb.co/7tBZVw7/Logo-Practifinder.png");

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

        businessToUpdate.setNombre(business.getNombre());
        businessToUpdate.setUsername(business.getUsername());
        businessToUpdate.setCorreo(business.getCorreo());
        businessToUpdate.setSiteWeb(business.getSiteWeb());

        if(business.getImagen() == null)
            business.setImagen("https://i.ibb.co/7tBZVw7/Logo-Practifinder.png");

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
    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    @Override
    public Business getBusinessById(Long businessId) {
        return businessRepository.findById(businessId)
                .orElseThrow(() -> new EntityNotFoundException("Business not found with id: " + businessId));
    }

    @Override
    public OfferInternship addOfferToBusiness(Long businessId, OfferInternship offer) {
        Business business = getBusinessById(businessId);
        offer.setBusiness(business);
        business.getOfertas().add(offer);
        businessRepository.save(business);
        return offer;
    }

    @Override
    public Business createWithMissingAttributes(Long businessId, CreateBusinessWithAttributesResource createBusinessWithAttributesResource) {

        Business existingBusiness = businessRepository.findById(businessId)
                .orElseThrow(() -> new EntityNotFoundException("Business not found with id: " + businessId));

        existingBusiness.setImagen(createBusinessWithAttributesResource.getImagen());
        existingBusiness.setLocation(createBusinessWithAttributesResource.getLocation());
        existingBusiness.setSiteWeb(createBusinessWithAttributesResource.getSiteWeb());

        if(existingBusiness.getImagen() == null)
            existingBusiness.setImagen("https://i.ibb.co/7tBZVw7/Logo-Practifinder.png");

        return businessRepository.save(existingBusiness);
    }

}
