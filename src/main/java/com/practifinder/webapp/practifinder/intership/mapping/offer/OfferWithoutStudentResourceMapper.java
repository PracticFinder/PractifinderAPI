package com.practifinder.webapp.practifinder.intership.mapping.offer;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternshipStudent;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferWithoutStudentResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class OfferWithoutStudentResourceMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public OfferWithoutStudentResource toResource(OfferInternshipStudent model){
        return mapper.map(model, OfferWithoutStudentResource.class);
    }

    public OfferInternshipStudent toModel(OfferWithoutStudentResource resource){
        return mapper.map(resource, OfferInternshipStudent.class);
    }

}
