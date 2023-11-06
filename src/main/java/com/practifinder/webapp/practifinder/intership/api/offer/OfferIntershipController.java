package com.practifinder.webapp.practifinder.intership.api.offer;

import com.practifinder.webapp.practifinder.intership.domain.offer.service.OfferIntershipService;
import com.practifinder.webapp.practifinder.intership.mapping.offer.OfferIntershipMapper;
import com.practifinder.webapp.practifinder.intership.resource.offer.CreateOfferIntershipResource;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferIntershipResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/offers")
public class OfferIntershipController {

    private final OfferIntershipService offerIntershipService;

    private final OfferIntershipMapper offerIntershipMapper;

    public OfferIntershipController(OfferIntershipService offerIntershipService, OfferIntershipMapper offerIntershipMapper){
        this.offerIntershipService = offerIntershipService;
        this.offerIntershipMapper = offerIntershipMapper;
    }

    @GetMapping
    public Page<OfferIntershipResource> getAllOfferIntership(Pageable pageable){
        return offerIntershipMapper.modelListPage(offerIntershipService.getAll(), pageable);
    }

    @GetMapping("{offerIntershipId}")
    public OfferIntershipResource getOfferIntershipById(@PathVariable Long offerIntershipId){
        return offerIntershipMapper.toResource(offerIntershipService.getById(offerIntershipId));
    }

    @PostMapping
    public ResponseEntity<OfferIntershipResource> createOfferIntership(@RequestBody CreateOfferIntershipResource resource){
        return new ResponseEntity<>( offerIntershipMapper.toResource(offerIntershipService.create(offerIntershipMapper.toModel(resource))), HttpStatus.CREATED);
    }



}
