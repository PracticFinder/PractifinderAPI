package com.practifinder.webapp.practifinder.lifescape.domain.knowledge.persistence;

import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnowledgeRepository extends JpaRepository<Knowledge, Long> {
    Knowledge findAllBy();

}
