package com.practifinder.webapp.practifinder.intership.mapping.offer;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntership;
import com.practifinder.webapp.practifinder.intership.resource.offer.CreateOfferIntershipResource;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferIntershipResource;
import com.practifinder.webapp.practifinder.intership.resource.offer.UpdateOfferIntershipResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class OfferIntershipMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public OfferIntershipResource toResource(OfferIntership model){
        return mapper.map(model, OfferIntershipResource.class);
    }

    public Page<OfferIntershipResource> modelListPage(List<OfferIntership> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, OfferIntershipResource.class), pageable, modelList.size());
    }

    public OfferIntership toModel(UpdateOfferIntershipResource resource){
        return mapper.map(resource, OfferIntership.class);
    }

    public OfferIntership toModel(CreateOfferIntershipResource resource){
        return mapper.map(resource, OfferIntership.class);
    }

}
