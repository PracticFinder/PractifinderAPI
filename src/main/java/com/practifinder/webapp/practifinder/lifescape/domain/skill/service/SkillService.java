package com.practifinder.webapp.practifinder.lifescape.domain.skill.service;

import com.practifinder.webapp.practifinder.lifescape.domain.skill.model.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SkillService {
    List<Skill> getAll();
    Page<Skill> getAll(Pageable pageable);

    Skill getById(Long skillId);

    Skill create(Skill skill);
    Skill update(Long id, Skill skill);
    ResponseEntity<?> delete(Long skillId);
}
