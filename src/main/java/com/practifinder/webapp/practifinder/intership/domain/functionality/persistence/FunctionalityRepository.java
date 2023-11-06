package com.practifinder.webapp.practifinder.intership.domain.functionality.persistence;

import com.practifinder.webapp.practifinder.intership.domain.functionality.model.Functionality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FunctionalityRepository extends JpaRepository<Functionality, Long> {
}
