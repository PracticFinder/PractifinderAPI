package com.practifinder.webapp.practifinder.notification.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("notificationMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public NotificationMapper notificationMapper() {
        return new NotificationMapper();
    }

    @Bean
    public NotificationStudentMapper notificationTypeMapper() {
        return new NotificationStudentMapper();
    }
}
