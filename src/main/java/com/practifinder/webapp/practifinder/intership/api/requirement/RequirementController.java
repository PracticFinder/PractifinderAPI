package com.practifinder.webapp.practifinder.intership.api.requirement;


import com.practifinder.webapp.practifinder.intership.domain.requirement.service.RequirementService;
import com.practifinder.webapp.practifinder.intership.mapping.requirement.RequirementMapper;
import com.practifinder.webapp.practifinder.intership.resource.requirement.CreateRequirementResource;
import com.practifinder.webapp.practifinder.intership.resource.requirement.RequirementResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/requirements")
public class RequirementController {
    private final RequirementService requirementService;

    private final RequirementMapper requirementMapper;

    public RequirementController(RequirementService requirementService, RequirementMapper requirementMapper){
        this.requirementMapper = requirementMapper;
        this.requirementService = requirementService;
    }

    @GetMapping
    public Page<RequirementResource> getAllRequirement(Pageable pageable){
        return requirementMapper.modelListPage(requirementService.getAll(), pageable);
    }

    @GetMapping("{requirementId}")
    public RequirementResource getRequirementById(@PathVariable Long requirementId){
        return requirementMapper.toResource(requirementService.getById(requirementId));
    }

    @PostMapping
    public ResponseEntity<RequirementResource> createRequirement(@RequestBody CreateRequirementResource resource){
        return new ResponseEntity<>(requirementMapper.toResource(requirementService.create(requirementMapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{requirementId}")
    public RequirementResource updateRequirement(@PathVariable Long requirementId, @RequestBody CreateRequirementResource resource){
        return requirementMapper.toResource(requirementService.update(requirementId,requirementMapper.toModel(resource)));
    }

    @DeleteMapping("{requirementId}")
    public ResponseEntity<?> deleteRequirement(@PathVariable Long requirementId){
        return requirementService.delete(requirementId);
    }

}
