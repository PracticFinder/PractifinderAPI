package com.practifinder.webapp.practifinder.intership.resource.offer;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class OfferWithoutStudentResource {
     private Long id;
     private OfferInternship offer;
}
