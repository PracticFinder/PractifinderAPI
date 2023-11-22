package com.practifinder.webapp.practifinder.profile.api.business;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import com.practifinder.webapp.practifinder.profile.domain.business.model.Business;
import com.practifinder.webapp.practifinder.profile.domain.business.service.BusinessService;
import com.practifinder.webapp.practifinder.profile.mapping.business.BusinessMapper;
import com.practifinder.webapp.practifinder.profile.resource.business.BusinessResource;
import com.practifinder.webapp.practifinder.profile.resource.business.CreateBusinessResource;
import com.practifinder.webapp.practifinder.profile.resource.business.CreateBusinessWithAttributesResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth/business")
public class BusinessController {
    private final BusinessService businessService;
    private final BusinessMapper businessMapper;

    public BusinessController(BusinessService businessService, BusinessMapper businessMapper) {
        this.businessService = businessService;
        this.businessMapper = businessMapper;
    }

    @GetMapping
    public Page<BusinessResource> getAllBusiness(Pageable pageable){
        return businessMapper.modelListPage(businessService.getAll(),pageable);
    }

    @PostMapping()
    public ResponseEntity<BusinessResource> createBusiness(@RequestBody CreateBusinessResource resource){
        return new ResponseEntity<>(businessMapper.toResource(businessService.create(businessMapper.toModel(resource))), HttpStatus.CREATED);
    }

    @DeleteMapping("{businessId}")
    public ResponseEntity<?> deleteBusiness(@PathVariable Long businessId){
        businessService.delete(businessId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{businessId}")
    public ResponseEntity<Business> getBusinessById(@PathVariable Long businessId) {
        Business business = businessService.getBusinessById(businessId);
        return new ResponseEntity<>(business, HttpStatus.OK);
    }

    @PostMapping("/{businessId}/offers")
    public ResponseEntity<OfferInternship> addOfferToBusiness(
            @PathVariable Long businessId,
            @RequestBody OfferInternship offer) {
        OfferInternship addedOffer = businessService.addOfferToBusiness(businessId, offer);
        return new ResponseEntity<>(addedOffer, HttpStatus.CREATED);
    }

    @PutMapping("/{businessId}")
    public ResponseEntity<Business> updateBusinessWithMissingAttributes(
            @PathVariable Long businessId,
            @RequestBody CreateBusinessWithAttributesResource resource) {
        Business updatedBusiness = businessService.createWithMissingAttributes(businessId, resource);
        return new ResponseEntity<>(updatedBusiness, HttpStatus.OK);
    }

}
