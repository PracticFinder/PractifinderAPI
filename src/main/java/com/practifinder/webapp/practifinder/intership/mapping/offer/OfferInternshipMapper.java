package com.practifinder.webapp.practifinder.intership.mapping.offer;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import com.practifinder.webapp.practifinder.intership.resource.offer.CreateOfferInternshipResource;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferInternshipResource;
import com.practifinder.webapp.practifinder.intership.resource.offer.UpdateOfferInternshipResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class OfferInternshipMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public OfferInternshipResource toResource(OfferInternship model){
        return mapper.map(model, OfferInternshipResource.class);
    }

    public Page<OfferInternshipResource> modelListPage(List<OfferInternship> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, OfferInternshipResource.class), pageable, modelList.size());
    }

    public OfferInternship toModel(UpdateOfferInternshipResource resource){
        return mapper.map(resource, OfferInternship.class);
    }

    public OfferInternship toModel(CreateOfferInternshipResource resource){
        return mapper.map(resource, OfferInternship.class);
    }

}
