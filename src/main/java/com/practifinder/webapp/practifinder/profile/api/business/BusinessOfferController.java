package com.practifinder.webapp.practifinder.profile.api.business;

import com.practifinder.webapp.practifinder.profile.domain.business.persistence.BusinessRepository;
import com.practifinder.webapp.practifinder.profile.domain.business.service.BusinessOfferService;
import com.practifinder.webapp.practifinder.profile.mapping.business.BusinessOfferMapper;
import com.practifinder.webapp.practifinder.profile.resource.business.BusinessOfferResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/businesses")
public class BusinessOfferController {

    private final BusinessOfferService businessOfferService;

    private final BusinessRepository businessRepository;

    private final BusinessOfferMapper mapper;

    public BusinessOfferController(BusinessOfferService businessOfferService, BusinessRepository businessRepository, BusinessOfferMapper mapper) {
        this.businessOfferService = businessOfferService;
        this.businessRepository = businessRepository;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<BusinessOfferResource> getAllBusinessOffers(Pageable pageable){
        return mapper.modelListPage(businessOfferService.getAll(),pageable);
    }

    @GetMapping("{businessId}/offers")
    public Page<BusinessOfferResource> getAllOffersByBusinessId(Pageable pageable, @PathVariable Long businessId){
        return mapper.modelListPage(businessOfferService.getAllByBusinessId(businessId),pageable);
    }

    @PostMapping("{businessId}/offers/{offerId}")
    public ResponseEntity<?> addOfferToBusiness(@PathVariable Long businessId,@PathVariable Long offerId){
        com.practifinder.webapp.practifinder.profile.domain.business.model.Business business=businessRepository.findById(businessId)
                .orElseThrow(()->new RuntimeException("The Business doesn't exist."));

        if(business.getOffersListByBusiness()!=null){
            boolean offerExist=business.getOffersListByBusiness().stream()
                    .anyMatch(offer->offer.getOfferId().equals(offerId));
            if(offerExist) return ResponseEntity.badRequest().body("These offer already exist for the Business.");
        }

        business.addOffer(business,offerId);
        businessRepository.save(business);

        return ResponseEntity.ok("Offer was added correctly.");
    }



}
