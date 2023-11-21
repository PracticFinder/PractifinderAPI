package com.practifinder.webapp.practifinder.experience.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("experienceMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ExperienceMapper experienceMapper(){ return new ExperienceMapper(); }

}
