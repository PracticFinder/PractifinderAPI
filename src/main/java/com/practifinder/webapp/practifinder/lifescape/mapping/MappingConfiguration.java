package com.practifinder.webapp.practifinder.lifescape.mapping;

import com.practifinder.webapp.practifinder.lifescape.mapping.knowledge.KnowledgeMapper;
import com.practifinder.webapp.practifinder.lifescape.mapping.language.LanguageMapper;
import com.practifinder.webapp.practifinder.lifescape.mapping.skill.SkillMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("languageMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public LanguageMapper languageMapper() {
        return new LanguageMapper();
    }

    @Bean
    public KnowledgeMapper knowledgeMapper() {
        return new KnowledgeMapper();
    }

    @Bean
    public SkillMapper skillMapper() {
        return new SkillMapper();
    }
}
