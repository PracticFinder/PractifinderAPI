package com.practifinder.webapp.practifinder.lifescape.api.skill;

import com.practifinder.webapp.practifinder.lifescape.domain.skill.service.SkillService;
import com.practifinder.webapp.practifinder.lifescape.mapping.skill.SkillMapper;
import com.practifinder.webapp.practifinder.lifescape.resource.skill.CreateSkillResource;
import com.practifinder.webapp.practifinder.lifescape.resource.skill.SkillResource;
import com.practifinder.webapp.practifinder.lifescape.resource.skill.UpdateSkillResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/skills")
public class SkillController {
    private final SkillService skillService;
    private final SkillMapper mapper;

    public SkillController(SkillService skillService, SkillMapper mapper){
        this.skillService = skillService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<SkillResource> getAllSkills(Pageable pageable){
        return mapper.modelListPage(skillService.getAll(), pageable);
    }

    @GetMapping("{skillId}")
    public SkillResource getSkillById(@PathVariable Long skillId){
        return mapper.toResource(skillService.getById(skillId));
    }

    @PostMapping
    public ResponseEntity<SkillResource> createSkill(@RequestBody CreateSkillResource resource){
        return new ResponseEntity<>(mapper.toResource(skillService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{skillId}")
    public SkillResource updateSkill(@PathVariable Long skillId,
                                     @RequestBody UpdateSkillResource resource){
        return mapper.toResource(skillService.update(skillId,mapper.toModel(resource)));
    }

    @DeleteMapping("{skillId}")
    public ResponseEntity<?> deleteSkill(@PathVariable Long skillId){
        return skillService.delete(skillId);
    }
}
