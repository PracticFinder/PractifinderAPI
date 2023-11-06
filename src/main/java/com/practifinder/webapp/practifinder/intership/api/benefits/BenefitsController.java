package com.practifinder.webapp.practifinder.intership.api.benefits;

import com.practifinder.webapp.practifinder.intership.domain.benefits.service.BenefitsService;
import com.practifinder.webapp.practifinder.intership.mapping.benefits.BenefitsMapper;
import com.practifinder.webapp.practifinder.intership.resource.benefits.BenefitsResource;
import com.practifinder.webapp.practifinder.intership.resource.benefits.CreateBenefitsResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/benefits")
public class BenefitsController {
    private static final String ENTITY = "Benefits";

    private final BenefitsService benefitsService;

    private final BenefitsMapper mapper;

    public BenefitsController(BenefitsService benefitsService, BenefitsMapper mapper){
        this.benefitsService = benefitsService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<BenefitsResource> getAllBenefits(Pageable pageable){
        return mapper.modelListPage(benefitsService.getAll(), pageable);
    }

    @GetMapping("{benefitsId}")
    public BenefitsResource getBenefitsById(@PathVariable Long benefitsId){
        return mapper.toResource(benefitsService.getById(benefitsId));
    }


    @PostMapping
    public ResponseEntity<BenefitsResource> createBenefits(@RequestBody CreateBenefitsResource resource){
        return new ResponseEntity<>(mapper.toResource(benefitsService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }


    @PutMapping("{benefitsId}")
    public BenefitsResource updateBenefits(@PathVariable Long benefitsId, @RequestBody CreateBenefitsResource resource){
        return mapper.toResource(benefitsService.update(benefitsId,mapper.toModel(resource)));
    }

    @DeleteMapping("{benefitsId}")
    public ResponseEntity<?> deleteBenefits(@PathVariable Long benefitsId){
        return benefitsService.delete(benefitsId);
    }



}
