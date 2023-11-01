package com.practifinder.webapp.practifinder.lifescape.domain.skill.persistence;

import com.practifinder.webapp.practifinder.lifescape.domain.skill.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    Skill findAllBy();
}
