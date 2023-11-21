package com.practifinder.webapp.practifinder.lifescape.domain.knowledge.persistence;

import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KnowledgeRepository extends JpaRepository<Knowledge, Long> {
    List<Knowledge> findByStudentId(Long studentId);
}
