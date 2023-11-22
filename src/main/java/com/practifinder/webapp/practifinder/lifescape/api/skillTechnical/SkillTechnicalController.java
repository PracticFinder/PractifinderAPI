package com.practifinder.webapp.practifinder.lifescape.api.skillTechnical;

import com.practifinder.webapp.practifinder.lifescape.domain.skillTechnical.service.SkillTechnicalService;
import com.practifinder.webapp.practifinder.lifescape.mapping.skillTechnical.SkillTechnicalMapper;
import com.practifinder.webapp.practifinder.lifescape.resource.skillTechnical.CreateSkillTechnicalResource;
import com.practifinder.webapp.practifinder.lifescape.resource.skillTechnical.SkillTechnicalResource;
import com.practifinder.webapp.practifinder.lifescape.resource.skillTechnical.UpdateSkillTechnicalResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/skills_technical")
public class SkillTechnicalController {

    private final SkillTechnicalService skillTechnicalService;
    private final SkillTechnicalMapper mapper;

    public SkillTechnicalController(SkillTechnicalService skillTechnicalService, SkillTechnicalMapper mapper) {
        this.skillTechnicalService = skillTechnicalService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<SkillTechnicalResource> getAllSkillsTechnical(Pageable pageable){
        return mapper.modelListPage(skillTechnicalService.getAll(), pageable);
    }

    @GetMapping("{skillId}")
    public SkillTechnicalResource getSkillTechnicalById(@PathVariable Long skillId){
        return mapper.toResource(skillTechnicalService.getById(skillId));
    }

    @PostMapping
    public ResponseEntity<SkillTechnicalResource> createSkill(@RequestBody CreateSkillTechnicalResource resource){
        return new ResponseEntity<>(mapper.toResource(skillTechnicalService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{skillId}")
    public SkillTechnicalResource updateSkill(@PathVariable Long skillId,
                                                  @RequestBody UpdateSkillTechnicalResource resource){
        return mapper.toResource(skillTechnicalService.update(skillId,mapper.toModel(resource)));
    }

    @DeleteMapping("{skillId}")
    public ResponseEntity<?> deleteSkill(@PathVariable Long skillId){
        return skillTechnicalService.delete(skillId);
    }

}
