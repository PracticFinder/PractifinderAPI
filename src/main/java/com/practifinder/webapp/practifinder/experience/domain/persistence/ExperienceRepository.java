package com.practifinder.webapp.practifinder.experience.domain.persistence;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
