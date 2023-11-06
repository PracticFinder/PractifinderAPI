package com.practifinder.webapp.practifinder.intership.domain.benefits.service;

import com.practifinder.webapp.practifinder.intership.domain.benefits.model.Benefits;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BenefitsService {
    List<Benefits> getAll();
    Page<Benefits> getAll(Pageable pageable);
    Benefits getById(Long benefitsId);
    Benefits create(Benefits benefits);
    Benefits update(Long id, Benefits benefits);
    ResponseEntity<?> delete(Long benefitsId);
}
