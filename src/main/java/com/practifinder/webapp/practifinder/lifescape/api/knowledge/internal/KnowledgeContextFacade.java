package com.practifinder.webapp.practifinder.lifescape.api.knowledge.internal;

import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;

import java.util.List;

public interface KnowledgeContextFacade {
    List<Knowledge> getAllKnowledge();
}
