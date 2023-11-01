package com.practifinder.webapp.practifinder.notification.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateNotificationResource {

        private Long id;

        private String type;

        private String message;

        private Long businessId;

        private Long studentId;

}
