package com.practifinder.webapp.practifinder.lifescape.domain.skillTechnical.repository;

import com.practifinder.webapp.practifinder.lifescape.domain.skillTechnical.model.SkillTechnical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillTechnicalRepository extends JpaRepository<SkillTechnical, Long> {

    List<SkillTechnical> findByStudentId(Long studentId);
}
