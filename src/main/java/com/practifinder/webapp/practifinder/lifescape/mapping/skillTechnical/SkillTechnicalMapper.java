package com.practifinder.webapp.practifinder.lifescape.mapping.skillTechnical;

import com.practifinder.webapp.practifinder.lifescape.domain.skillTechnical.model.SkillTechnical;
import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.model.SkillInterpersonal;
import com.practifinder.webapp.practifinder.lifescape.resource.skillInterpersonal.SkillInterpersonalResource;
import com.practifinder.webapp.practifinder.lifescape.resource.skillTechnical.CreateSkillTechnicalResource;
import com.practifinder.webapp.practifinder.lifescape.resource.skillTechnical.SkillTechnicalResource;
import com.practifinder.webapp.practifinder.lifescape.resource.skillTechnical.UpdateSkillTechnicalResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class SkillTechnicalMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;
    public SkillTechnicalResource toResource(SkillTechnical model){
        return mapper.map(model, SkillTechnicalResource.class);
    }
    public SkillTechnical toModel(CreateSkillTechnicalResource resource){
        return mapper.map(resource, SkillTechnical.class);
    }

    public SkillTechnical toModel(UpdateSkillTechnicalResource resource){
        return mapper.map(resource, SkillTechnical.class);
    }
    public Page<SkillTechnicalResource> modelListPage (List<SkillTechnical> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, SkillTechnicalResource.class), pageable, modelList.size());
    }
}
