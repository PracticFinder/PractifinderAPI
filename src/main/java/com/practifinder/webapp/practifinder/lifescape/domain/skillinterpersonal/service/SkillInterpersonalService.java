package com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.service;

import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.model.SkillInterpersonal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SkillInterpersonalService {
    List<SkillInterpersonal> getAll();
    Page<SkillInterpersonal> getAll(Pageable pageable);

    SkillInterpersonal getById(Long skillId);

    SkillInterpersonal create(SkillInterpersonal skillInterpersonal);
    SkillInterpersonal update(Long id, SkillInterpersonal skillInterpersonal);
    ResponseEntity<?> delete(Long skillId);

    List<SkillInterpersonal> getByStudentId(Long studentId);
}
