package com.practifinder.webapp.practifinder.lifescape.mapping.skillInterpersonal;

import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.model.SkillInterpersonal;
import com.practifinder.webapp.practifinder.lifescape.resource.skillInterpersonal.CreateSkillInterpersonalResource;
import com.practifinder.webapp.practifinder.lifescape.resource.skillInterpersonal.SkillInterpersonalResource;
import com.practifinder.webapp.practifinder.lifescape.resource.skillInterpersonal.UpdateSkillInterpersonalResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class SkillInterpersonalMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;
    public SkillInterpersonalResource toResource(SkillInterpersonal model){
        return mapper.map(model, SkillInterpersonalResource.class);
    }
    public SkillInterpersonal toModel(CreateSkillInterpersonalResource resource){
        return mapper.map(resource, SkillInterpersonal.class);
    }

    public SkillInterpersonal toModel(UpdateSkillInterpersonalResource resource){
        return mapper.map(resource, SkillInterpersonal.class);
    }
    public Page<SkillInterpersonalResource> modelListPage (List<SkillInterpersonal> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, SkillInterpersonalResource.class), pageable, modelList.size());
    }

}
