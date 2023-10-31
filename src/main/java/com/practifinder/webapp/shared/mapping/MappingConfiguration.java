package com.practifinder.webapp.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration") //It serves to differentiate itself from the class that is in the bounded context
public class MappingConfiguration {

    @Bean
    public EnhancedModelMapper modelMapper(){
        return new EnhancedModelMapper();
    }
}
