package com.practifinder.webapp.practifinder.intership.resource.functionality;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class FunctionalityResource {
    Long id;
    String description;
    Long offerInternshipId;
}
