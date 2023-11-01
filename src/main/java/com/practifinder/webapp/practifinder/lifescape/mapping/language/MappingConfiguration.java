package com.practifinder.webapp.practifinder.lifescape.mapping.language;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration ("languageMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public LanguageMapper languageMapper() {
        return new LanguageMapper();
    }
}
