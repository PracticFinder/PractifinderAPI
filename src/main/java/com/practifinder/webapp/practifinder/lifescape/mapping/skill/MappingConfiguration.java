package com.practifinder.webapp.practifinder.lifescape.mapping.skill;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("skillMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public SkillMapper skillMapper() {
        return new SkillMapper();
    }
}
