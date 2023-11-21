package com.practifinder.webapp.practifinder.lifescape.api.skillInterpersonal;

import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.service.SkillInterpersonalService;
import com.practifinder.webapp.practifinder.lifescape.mapping.skillInterpersonal.SkillInterpersonalMapper;
import com.practifinder.webapp.practifinder.lifescape.resource.skillInterpersonal.CreateSkillInterpersonalResource;
import com.practifinder.webapp.practifinder.lifescape.resource.skillInterpersonal.SkillInterpersonalResource;
import com.practifinder.webapp.practifinder.lifescape.resource.skillInterpersonal.UpdateSkillInterpersonalResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/skills_interpersonal")
public class SkillInterpersonalController {
    private final SkillInterpersonalService skillInterpersonalService;
    private final SkillInterpersonalMapper mapper;

    public SkillInterpersonalController(SkillInterpersonalService skillInterpersonalService, SkillInterpersonalMapper mapper){
        this.skillInterpersonalService = skillInterpersonalService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<SkillInterpersonalResource> getAllSkills(Pageable pageable){
        return mapper.modelListPage(skillInterpersonalService.getAll(), pageable);
    }

    @GetMapping("{skillId}")
    public SkillInterpersonalResource getSkillById(@PathVariable Long skillId){
        return mapper.toResource(skillInterpersonalService.getById(skillId));
    }

    @PostMapping
    public ResponseEntity<SkillInterpersonalResource> createSkill(@RequestBody CreateSkillInterpersonalResource resource){
        return new ResponseEntity<>(mapper.toResource(skillInterpersonalService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{skillId}")
    public SkillInterpersonalResource updateSkill(@PathVariable Long skillId,
                                                  @RequestBody UpdateSkillInterpersonalResource resource){
        return mapper.toResource(skillInterpersonalService.update(skillId,mapper.toModel(resource)));
    }

    @DeleteMapping("{skillId}")
    public ResponseEntity<?> deleteSkill(@PathVariable Long skillId){
        return skillInterpersonalService.delete(skillId);
    }
}
