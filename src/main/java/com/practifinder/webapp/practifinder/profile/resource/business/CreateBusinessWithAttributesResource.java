package com.practifinder.webapp.practifinder.profile.resource.business;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@Getter
@Setter
public class CreateBusinessWithAttributesResource {

    private String location;

    @URL
    private String imagen;


    @Size(max = 200)
    private String siteWeb;
}
