package com.practifinder.webapp.practifinder.lifescape.api.skill;

import com.practifinder.webapp.practifinder.lifescape.domain.skill.model.Skill;

import java.util.List;

public interface SkillContextFacade {
    List<Skill> getAllSkills();
}
