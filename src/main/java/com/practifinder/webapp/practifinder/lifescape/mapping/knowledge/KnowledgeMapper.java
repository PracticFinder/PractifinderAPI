package com.practifinder.webapp.practifinder.lifescape.mapping.knowledge;

import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import com.practifinder.webapp.practifinder.lifescape.resource.knowledge.CreateKnowledgeResource;
import com.practifinder.webapp.practifinder.lifescape.resource.knowledge.KnowledgeResource;
import com.practifinder.webapp.practifinder.lifescape.resource.knowledge.UpdateKnowledgeResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class KnowledgeMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public KnowledgeResource toResource(Knowledge model){
        return mapper.map(model, KnowledgeResource.class);
    }

    public Knowledge toModel(CreateKnowledgeResource resource){
        return mapper.map(resource, Knowledge.class);
    }

    public Knowledge toModel(UpdateKnowledgeResource resource){
        return mapper.map(resource, Knowledge.class);
    }

    public Page<KnowledgeResource> modelListPage(List<Knowledge> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, KnowledgeResource.class), pageable, modelList.size());
    }
}
