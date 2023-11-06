package com.practifinder.webapp.practifinder.intership.domain.requirement.service;

import com.practifinder.webapp.practifinder.intership.domain.requirement.model.Requirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RequirementService {
    List<Requirement> getAll();
    Page<Requirement> getAll(Pageable pageable);
    Requirement getById(Long id);
    Requirement create(Requirement requirement);
    Requirement update(Long id, Requirement requirement);
    ResponseEntity<?> delete(Long id);

}
