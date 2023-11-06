package com.practifinder.webapp.practifinder.intership.domain.requirement.persistence;

import com.practifinder.webapp.practifinder.intership.domain.requirement.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {

}
