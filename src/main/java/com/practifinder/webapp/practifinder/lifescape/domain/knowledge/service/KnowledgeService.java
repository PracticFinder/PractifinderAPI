package com.practifinder.webapp.practifinder.lifescape.domain.knowledge.service;

import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface KnowledgeService {
    List<Knowledge> getAll();

    Page<Knowledge> getAll(Pageable pageable);

    Knowledge getById(Long knowledgeId);

    Knowledge create(Knowledge knowledge);
    Knowledge update(Long id ,Knowledge knowledge);
    ResponseEntity<?> delete(Long knowledgeId);

    List<Knowledge> getByStudentId(Long studentId);
}
