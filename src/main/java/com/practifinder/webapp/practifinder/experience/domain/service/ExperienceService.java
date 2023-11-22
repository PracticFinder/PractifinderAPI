package com.practifinder.webapp.practifinder.experience.domain.service;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.experience.resource.CreateExperienceResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExperienceService {
    List<Experience> getAll();
    Page<Experience> getAll(Pageable pageable);
    Experience getById(Long experienceId);
    Experience create(CreateExperienceResource createExperienceResource);
    Experience update(Long id, Experience experience);
    ResponseEntity<?> delete(Long experienceId);

    List<Experience> getByStudentId(Long studentId);
}
