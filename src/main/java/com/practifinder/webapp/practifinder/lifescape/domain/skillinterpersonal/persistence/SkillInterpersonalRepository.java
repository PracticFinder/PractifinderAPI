package com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.persistence;

import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.model.SkillInterpersonal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillInterpersonalRepository extends JpaRepository<SkillInterpersonal, Long> {
    List<SkillInterpersonal> findByStudentId(Long studentId);
}
