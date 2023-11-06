package com.practifinder.webapp.practifinder.intership.mapping.benefits;

import com.practifinder.webapp.practifinder.intership.domain.benefits.model.Benefits;
import com.practifinder.webapp.practifinder.intership.resource.benefits.BenefitsResource;
import com.practifinder.webapp.practifinder.intership.resource.benefits.CreateBenefitsResource;
import com.practifinder.webapp.practifinder.intership.resource.benefits.UpdateBenefitsResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class BenefitsMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public BenefitsResource toResource(Benefits model){
        return mapper.map(model, BenefitsResource.class);
    }

    public Benefits toModel(CreateBenefitsResource resource){
        return mapper.map(resource, Benefits.class);
    }

    public Benefits toModel(UpdateBenefitsResource resource){
        return mapper.map(resource, Benefits.class);
    }

    public Page<BenefitsResource> modelListPage (List<Benefits> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, BenefitsResource.class), pageable, modelList.size());
    }

}
