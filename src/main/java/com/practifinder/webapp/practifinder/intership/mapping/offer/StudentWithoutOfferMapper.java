package com.practifinder.webapp.practifinder.intership.mapping.offer;


import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternshipStudent;
import com.practifinder.webapp.practifinder.intership.resource.offer.StudentWithoutOfferResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;


public class StudentWithoutOfferMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public StudentWithoutOfferResource toResource(OfferInternshipStudent model){
        return mapper.map(model, StudentWithoutOfferResource.class);
    }

    public OfferInternshipStudent toModel(StudentWithoutOfferResource resource){
        return mapper.map(resource, OfferInternshipStudent.class);
    }



}
