package com.practifinder.webapp.practifinder.intership.api.functionality;


import com.practifinder.webapp.practifinder.intership.domain.functionality.service.FunctionalityService;
import com.practifinder.webapp.practifinder.intership.mapping.functionality.FunctionalityMapper;
import com.practifinder.webapp.practifinder.intership.resource.functionality.CreateFunctionalityResource;
import com.practifinder.webapp.practifinder.intership.resource.functionality.FunctionalityResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/functionality")
public class FunctionalityController {
    private final FunctionalityService functionalityService;
    private final FunctionalityMapper functionalityMapper;

    public FunctionalityController(FunctionalityService functionalityService, FunctionalityMapper functionalityMapper){
        this.functionalityService = functionalityService;
        this.functionalityMapper = functionalityMapper;
    }

    @GetMapping
    public Page<FunctionalityResource> getAllFunctionality(Pageable pageable){
        return functionalityMapper.modelListPage(functionalityService.getAll(), pageable);
    }

    @GetMapping("{functionalityId}")
    public FunctionalityResource getFunctionalityById(@PathVariable Long functionalityId){
        return functionalityMapper.toResource(functionalityService.getById(functionalityId));
    }

    @PostMapping
    public ResponseEntity<FunctionalityResource> createFunctionality(@RequestBody CreateFunctionalityResource resource){
        return new ResponseEntity<>(functionalityMapper.toResource(functionalityService.create(functionalityMapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{functionalityId}")
    public FunctionalityResource updateFunctionality(@PathVariable Long functionalityId, @RequestBody CreateFunctionalityResource resource){
        return functionalityMapper.toResource(functionalityService.update(functionalityId,functionalityMapper.toModel(resource)));
    }

    @DeleteMapping("{functionalityId}")
    public ResponseEntity<?> deleteFunctionality(@PathVariable Long functionalityId){
        return functionalityService.delete(functionalityId);
    }

}
