package com.practifinder.webapp.practifinder.lifescape.mapping.skill;

import com.practifinder.webapp.practifinder.lifescape.domain.skill.model.Skill;
import com.practifinder.webapp.practifinder.lifescape.resource.skill.CreateSkillResource;
import com.practifinder.webapp.practifinder.lifescape.resource.skill.SkillResource;
import com.practifinder.webapp.practifinder.lifescape.resource.skill.UpdateSkillResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class SkillMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;
    public SkillResource toResource(Skill model){
        return mapper.map(model, SkillResource.class);
    }
    public Skill toModel(CreateSkillResource resource){
        return mapper.map(resource, Skill.class);
    }

    public Skill toModel(UpdateSkillResource resource){
        return mapper.map(resource, Skill.class);
    }
    public Page<SkillResource> modelListPage (List<Skill> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, SkillResource.class), pageable, modelList.size());
    }

}
