package com.practifinder.webapp.practifinder.profile.resource.business;

import com.practifinder.webapp.practifinder.profile.domain.business.model.Business;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class BusinessOfferResource {
    private Long offerId;
    private Business business;
}
