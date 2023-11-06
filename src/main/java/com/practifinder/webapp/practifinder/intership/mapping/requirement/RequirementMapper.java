package com.practifinder.webapp.practifinder.intership.mapping.requirement;

import com.practifinder.webapp.practifinder.intership.domain.requirement.model.Requirement;
import com.practifinder.webapp.practifinder.intership.resource.requirement.CreateRequirementResource;
import com.practifinder.webapp.practifinder.intership.resource.requirement.RequirementResource;
import com.practifinder.webapp.practifinder.intership.resource.requirement.UpdateRequirementResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class RequirementMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public RequirementResource toResource(Requirement model){
        return mapper.map(model,RequirementResource.class); }

    public Requirement toModel(CreateRequirementResource resource){ return mapper.map(resource,Requirement.class);}

    public Requirement toModel(UpdateRequirementResource resource){ return mapper.map(resource,Requirement.class);}

    public Page<RequirementResource> modelListPage (List<Requirement> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,RequirementResource.class),pageable,modelList.size());
    }

}
