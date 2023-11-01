package com.practifinder.webapp.practifinder.experience.domain.service;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExperienceService {
    List<Experience> getAll();
    Page<Experience> getAll(Pageable pageable);
    Experience getById(Long experienceId);
    Experience create(Experience experience);
    Experience update(Long id, Experience experience);
    ResponseEntity<?> delete(Long experienceId);
}
