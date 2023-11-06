package com.practifinder.webapp.practifinder.intership.mapping;

import com.practifinder.webapp.practifinder.intership.mapping.benefits.BenefitsMapper;
import com.practifinder.webapp.practifinder.intership.mapping.functionality.FunctionalityMapper;
import com.practifinder.webapp.practifinder.intership.mapping.offer.OfferIntershipMapper;
import com.practifinder.webapp.practifinder.intership.mapping.offer.OfferIntershipStudentMapper;
import com.practifinder.webapp.practifinder.intership.mapping.requirement.RequirementMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("InternshipMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public OfferIntershipMapper offerIntershipMapper() {
        return new OfferIntershipMapper();
    }

    @Bean
    public OfferIntershipStudentMapper offerIntershipStudentMapper() {
        return new OfferIntershipStudentMapper();
    }

    @Bean
    public FunctionalityMapper functionalityMapper() {
        return new FunctionalityMapper();
    }

    @Bean
    public BenefitsMapper benefitsMapper() {
        return new BenefitsMapper();
    }

    @Bean
    public RequirementMapper requirementMapper() {
        return new RequirementMapper();
    }
}
