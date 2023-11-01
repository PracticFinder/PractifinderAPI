package com.practifinder.webapp.practifinder.experience.api;

import com.practifinder.webapp.practifinder.experience.domain.service.ExperienceService;
import com.practifinder.webapp.practifinder.experience.mapping.ExperienceMapper;
import com.practifinder.webapp.practifinder.experience.resource.CreateExperienceResource;
import com.practifinder.webapp.practifinder.experience.resource.ExperienceResource;
import com.practifinder.webapp.practifinder.profile.resource.intern.StudentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/experience")
public class ExperienceController {

    private final ExperienceService experienceService;
    private final ExperienceMapper mapper;

    public ExperienceController(ExperienceService experienceService, ExperienceMapper mapper) {
        this.experienceService = experienceService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ExperienceResource> getAllExperiences(Pageable pageable){
        return mapper.modelListPage(experienceService.getAll(), pageable);
    }

    @GetMapping("{experienceId}")
    public ExperienceResource getExperienceById(@PathVariable Long experienceId){
        return mapper.toResource(experienceService.getById(experienceId));
    }
    @PostMapping
    public ResponseEntity<ExperienceResource> createExperience(@RequestBody CreateExperienceResource resource){
        return new ResponseEntity<>(mapper.toResource(experienceService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
    @DeleteMapping("{experienceId}")
    public ResponseEntity<?> deleteExperience(@PathVariable Long experienceId){

        return experienceService.delete(experienceId);
    }

}
