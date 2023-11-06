package com.practifinder.webapp.practifinder.intership.resource.requirement;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class RequirementResource {
    Long id;
    String description;
    Long offerInternshipId;
}
