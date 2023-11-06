package com.practifinder.webapp.practifinder.profile.mapping.business;

import com.practifinder.webapp.practifinder.profile.domain.business.model.BusinessOffer;
import com.practifinder.webapp.practifinder.profile.resource.business.BusinessOfferResource;
import com.practifinder.webapp.practifinder.profile.resource.business.CreateBusinessOfferResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class BusinessOfferMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public BusinessOfferResource toResource(BusinessOffer model){
        return mapper.map(model, BusinessOfferResource.class);
    }

    public BusinessOffer toModel(CreateBusinessOfferResource resource){
        return mapper.map(resource,BusinessOffer.class);
    }

    public Page<BusinessOfferResource> modelListPage(List<BusinessOffer> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,BusinessOfferResource.class),pageable,modelList.size());
    }


}
