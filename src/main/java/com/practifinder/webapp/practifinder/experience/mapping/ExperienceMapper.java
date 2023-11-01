package com.practifinder.webapp.practifinder.experience.mapping;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.experience.domain.service.ExperienceService;
import com.practifinder.webapp.practifinder.experience.resource.CreateExperienceResource;
import com.practifinder.webapp.practifinder.experience.resource.ExperienceResource;
import com.practifinder.webapp.practifinder.experience.resource.UpdateExperienceResource;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import com.practifinder.webapp.practifinder.profile.resource.intern.StudentResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ExperienceMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public ExperienceResource toResource(Experience model){
        return mapper.map(model,ExperienceResource.class);
    }

    public Experience toModel(CreateExperienceResource resource){
        return mapper.map(resource,Experience.class);
    }

    public Experience toModel(UpdateExperienceResource resource){

        return mapper.map(resource,Experience.class);
    }

    public Page<ExperienceResource> modelListPage(List<Experience> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,ExperienceResource.class),pageable,modelList.size());
    }
}
