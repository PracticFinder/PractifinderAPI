package com.practifinder.webapp.practifinder.intership.mapping.offer;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntershipStudent;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferIntershipStudentResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class OfferIntershipStudentMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public OfferIntershipStudentResource toResource(OfferIntershipStudent model){
        return mapper.map(model, OfferIntershipStudentResource.class); }

    public Page<OfferIntershipStudentResource> modelListPage(List<OfferIntershipStudent> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, OfferIntershipStudentResource.class), pageable, modelList.size());
    }

    public OfferIntershipStudent toModel(OfferIntershipStudentResource resource){ return mapper.map(resource, OfferIntershipStudent.class);}
}
