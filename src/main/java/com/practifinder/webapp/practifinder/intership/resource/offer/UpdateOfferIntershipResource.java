package com.practifinder.webapp.practifinder.intership.resource.offer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class UpdateOfferIntershipResource {
    private Long id;
    private String title;

    private String description;

    private Date dateInit;

    private Date dateEnd;

    private String location;
}
