package com.practifinder.webapp.practifinder.intership.domain.benefits.persistence;

import com.practifinder.webapp.practifinder.intership.domain.benefits.model.Benefits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenefitsRepository extends JpaRepository<Benefits, Long> {

}
