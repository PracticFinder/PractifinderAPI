package com.practifinder.webapp.practifinder.profile.domain.business.persistence;

import com.practifinder.webapp.practifinder.profile.domain.business.model.BusinessOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessOfferRepository extends JpaRepository<BusinessOffer,Long> {

    List<BusinessOffer> findAllByBusinessId(Long businessId);

}
