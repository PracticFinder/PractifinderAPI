package com.practifinder.webapp.practifinder.profile.domain.business.persistence;

import com.practifinder.webapp.practifinder.profile.domain.business.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business,Long> {

    Business findFirstByCorreo(String email);

}
