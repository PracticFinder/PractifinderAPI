package com.practifinder.webapp.practifinder.profile.mapping;

import com.practifinder.webapp.practifinder.profile.mapping.business.BusinessMapper;
import com.practifinder.webapp.practifinder.profile.mapping.intern.StudentMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("profileMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public BusinessMapper businessMapper(){ return new BusinessMapper(); }


    @Bean
    public StudentMapper studentMapper() {
        return new StudentMapper();
    }
}
