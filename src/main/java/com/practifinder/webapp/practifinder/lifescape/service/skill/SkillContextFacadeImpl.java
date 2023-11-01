package com.practifinder.webapp.practifinder.lifescape.service.skill;

import com.practifinder.webapp.practifinder.lifescape.api.skill.SkillContextFacade;
import com.practifinder.webapp.practifinder.lifescape.domain.skill.model.Skill;
import com.practifinder.webapp.practifinder.lifescape.domain.skill.service.SkillService;

import java.util.List;

public class SkillContextFacadeImpl implements SkillContextFacade {

    private final SkillService skillService;
    public SkillContextFacadeImpl(SkillService skillService){
        this.skillService = skillService;
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillService.getAll();
    }
}
