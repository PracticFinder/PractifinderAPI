package com.practifinder.webapp.practifinder.intership.domain.functionality.service;

import com.practifinder.webapp.practifinder.intership.domain.functionality.model.Functionality;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FunctionalityService {
    List<Functionality> getAll();
    Page<Functionality> getAll(Pageable pageable);
    Functionality getById(Long id);
    Functionality create(Functionality functionality);
    Functionality update(Long id, Functionality functionality);
    ResponseEntity<?> delete(Long id);
}
