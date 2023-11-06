package com.practifinder.webapp.practifinder.intership.mapping.functionality;

import com.practifinder.webapp.practifinder.intership.domain.functionality.model.Functionality;
import com.practifinder.webapp.practifinder.intership.resource.functionality.CreateFunctionalityResource;
import com.practifinder.webapp.practifinder.intership.resource.functionality.FunctionalityResource;
import com.practifinder.webapp.practifinder.intership.resource.functionality.UpdateFunctionalityResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class FunctionalityMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public FunctionalityResource toResource(Functionality model){
        return mapper.map(model, FunctionalityResource.class);
    }

    public Functionality toModel(CreateFunctionalityResource resource){
        return mapper.map(resource, Functionality.class);
    }

    public Functionality toModel(UpdateFunctionalityResource resource){
        return mapper.map(resource, Functionality.class);
    }

    public Page<FunctionalityResource> modelListPage (List<Functionality> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, FunctionalityResource.class), pageable, modelList.size());
    }

}
