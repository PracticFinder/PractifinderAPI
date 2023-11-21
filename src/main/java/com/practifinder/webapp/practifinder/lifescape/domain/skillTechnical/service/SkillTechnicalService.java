package com.practifinder.webapp.practifinder.lifescape.domain.skillTechnical.service;

import com.practifinder.webapp.practifinder.lifescape.domain.skillTechnical.model.SkillTechnical;
import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.model.SkillInterpersonal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SkillTechnicalService {
    List<SkillTechnical> getAll();
    Page<SkillTechnical> getAll(Pageable pageable);

    SkillTechnical getById(Long skillId);

    SkillTechnical create(SkillTechnical skillTechnical);
    SkillTechnical update(Long id, SkillTechnical skillTechnical);
    ResponseEntity<?> delete(Long skillId);
}

