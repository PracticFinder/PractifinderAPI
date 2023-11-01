package com.practifinder.webapp.practifinder.profile.api.business;

import com.practifinder.webapp.practifinder.profile.domain.business.service.BusinessService;
import com.practifinder.webapp.practifinder.profile.mapping.business.BusinessMapper;
import com.practifinder.webapp.practifinder.profile.resource.business.BusinessResource;
import com.practifinder.webapp.practifinder.profile.resource.business.CreateBusinessResource;
import com.practifinder.webapp.practifinder.profile.resource.business.UpdateBusinessResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/business")
public class BusinessController {
    private BusinessService businessService;
    private BusinessMapper businessMapper;

    public BusinessController(BusinessService businessService, BusinessMapper businessMapper) {
        this.businessService = businessService;
        this.businessMapper = businessMapper;
    }

    @GetMapping
    public Page<BusinessResource> getAllBusiness(Pageable pageable){
        return businessMapper.modelListPage(businessService.getAll(),pageable);
    }

    @GetMapping("{businessId}")
    public BusinessResource getBusinessById(@PathVariable Long businessId){
        return businessMapper.toResource(businessService.getById(businessId));
    }

    @PostMapping()
    public ResponseEntity<BusinessResource> createBusiness(@RequestBody CreateBusinessResource resource){
        return new ResponseEntity<>(businessMapper.toResource(businessService.create(businessMapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{businessId}")
    public BusinessResource updateBusiness(@PathVariable Long businessId, @RequestBody UpdateBusinessResource resource){
        return businessMapper.toResource(businessService.update(businessId,businessMapper.toModel(resource)));
    }

    @DeleteMapping("{businessId}")
    public ResponseEntity<?> deleteBusiness(@PathVariable Long businessId){
        businessService.delete(businessId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
