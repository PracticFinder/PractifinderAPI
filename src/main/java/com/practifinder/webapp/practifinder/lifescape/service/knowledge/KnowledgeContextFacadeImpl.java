package com.practifinder.webapp.practifinder.lifescape.service.knowledge;

import com.practifinder.webapp.practifinder.lifescape.api.knowledge.internal.KnowledgeContextFacade;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.service.KnowledgeService;

import java.util.List;

public class KnowledgeContextFacadeImpl implements KnowledgeContextFacade {
    private final KnowledgeService knowledgeService;

    public KnowledgeContextFacadeImpl(KnowledgeService knowledgeService){
        this.knowledgeService = knowledgeService;
    }

    @Override
    public List<Knowledge> getAllKnowledge(){
        return knowledgeService.getAll();
    }
}
