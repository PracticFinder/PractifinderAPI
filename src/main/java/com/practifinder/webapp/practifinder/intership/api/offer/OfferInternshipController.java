package com.practifinder.webapp.practifinder.intership.api.offer;

import com.practifinder.webapp.practifinder.intership.domain.offer.service.OfferInternshipService;
import com.practifinder.webapp.practifinder.intership.mapping.offer.OfferInternshipMapper;
import com.practifinder.webapp.practifinder.intership.resource.offer.CreateOfferInternshipResource;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferInternshipResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/offers")
public class OfferInternshipController {

    private final OfferInternshipService offerInternshipService;
    private final OfferInternshipMapper offerInternshipMapper;

    public OfferInternshipController(OfferInternshipService offerInternshipService, OfferInternshipMapper offerInternshipMapper){
        this.offerInternshipService = offerInternshipService;
        this.offerInternshipMapper = offerInternshipMapper;
    }

    @GetMapping
    public Page<OfferInternshipResource> getAllOfferInternship(Pageable pageable){
        return offerInternshipMapper.modelListPage(offerInternshipService.getAll(), pageable);
    }

    @GetMapping("{offerInternshipId}")
    public OfferInternshipResource getOfferInternshipById(@PathVariable Long offerInternshipId){
        return offerInternshipMapper.toResource(offerInternshipService.getById(offerInternshipId));
    }

    @PostMapping
    public ResponseEntity<OfferInternshipResource> createOfferInternship(@RequestBody CreateOfferInternshipResource resource){
        return new ResponseEntity<>( offerInternshipMapper.toResource(offerInternshipService.create(offerInternshipMapper.toModel(resource))), HttpStatus.CREATED);
    }



}
