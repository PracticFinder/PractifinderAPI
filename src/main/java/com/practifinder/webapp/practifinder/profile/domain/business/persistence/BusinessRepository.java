package com.practifinder.webapp.practifinder.profile.domain.business.persistence;

import com.practifinder.webapp.practifinder.profile.domain.business.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business,Long> {
    Business findByName(String name);
    Business findByEmail(String email);
    Business findBySiteWeb(String siteWeb);
    Business findByLocation(String location);

    Business findFirstByEmail(String email);

    Business findFirstByName(String name);

    Business findFirstBySiteWeb(String siteWeb);
}
