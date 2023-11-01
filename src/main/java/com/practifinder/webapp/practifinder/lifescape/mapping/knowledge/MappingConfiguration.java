package com.practifinder.webapp.practifinder.lifescape.mapping.knowledge;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("knowledgeMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public KnowledgeMapper knowledgeMapper() {
        return new KnowledgeMapper();
    }
}
