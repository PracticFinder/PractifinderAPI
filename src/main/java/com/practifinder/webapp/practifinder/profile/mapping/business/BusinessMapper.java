package com.practifinder.webapp.practifinder.profile.mapping.business;

import com.practifinder.webapp.practifinder.profile.domain.business.model.Business;
import com.practifinder.webapp.practifinder.profile.resource.business.BusinessResource;
import com.practifinder.webapp.practifinder.profile.resource.business.CreateBusinessResource;
import com.practifinder.webapp.practifinder.profile.resource.business.UpdateBusinessResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class BusinessMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public BusinessResource toResource(Business model){
        return mapper.map(model,BusinessResource.class);
    }

    public Business toModel(CreateBusinessResource resource){
        return mapper.map(resource,Business.class);
    }

    public Business toModel(UpdateBusinessResource resource){
        return mapper.map(resource,Business.class);
    }

    public Page<BusinessResource> modelListPage(List<Business> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,BusinessResource.class),pageable,modelList.size());
    }

}
