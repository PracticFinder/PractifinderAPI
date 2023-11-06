package com.practifinder.webapp.practifinder.intership.resource.benefits;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class BenefitsResource {
    Long id;
    String description;
    Double salary;
    Long offerInternshipId;
}
