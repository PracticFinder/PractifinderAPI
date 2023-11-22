package com.practifinder.webapp.practifinder.intership.mapping;


import com.practifinder.webapp.practifinder.intership.mapping.offer.OfferIntershipStudentsMapper;
import com.practifinder.webapp.practifinder.intership.mapping.offer.OfferWithoutStudentResourceMapper;
import com.practifinder.webapp.practifinder.intership.mapping.offer.OfferIntershipStudentMapper;
import com.practifinder.webapp.practifinder.intership.mapping.offer.StudentWithoutOfferMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("InternshipMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public OfferWithoutStudentResourceMapper offerInternshipMapper() {
        return new OfferWithoutStudentResourceMapper();
    }

    @Bean
    public OfferIntershipStudentMapper offerIntershipStudentMapper() {
        return new OfferIntershipStudentMapper();
    }

    @Bean
    public StudentWithoutOfferMapper studentWithoutOfferMapper() {
        return new StudentWithoutOfferMapper();
    }

    @Bean
    public OfferIntershipStudentsMapper enhancedModelMapper() {
        return new OfferIntershipStudentsMapper();
    }
}
