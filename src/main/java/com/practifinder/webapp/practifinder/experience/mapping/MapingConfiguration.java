package com.practifinder.webapp.practifinder.experience.mapping;

import com.practifinder.webapp.practifinder.profile.mapping.intern.StudentMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("experienceMappingConfiguration")

public class MapingConfiguration {
    @Bean
    public ExperienceMapper experienceMapper(){ return new ExperienceMapper(); }

}
