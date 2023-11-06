package com.practifinder.webapp.practifinder.intership.resource.offer;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntership;
import lombok.*;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class OfferIntershipStudentResource {
    private Long studentId;
    private OfferIntership offerIntership;
}
