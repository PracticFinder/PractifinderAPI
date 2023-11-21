package com.practifinder.webapp.practifinder.intership.mapping;


import com.practifinder.webapp.practifinder.intership.mapping.offer.OfferInternshipMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("InternshipMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public OfferInternshipMapper offerInternshipMapper() {
        return new OfferInternshipMapper();
    }


}
