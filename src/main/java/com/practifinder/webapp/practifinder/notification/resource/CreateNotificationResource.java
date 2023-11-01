package com.practifinder.webapp.practifinder.notification.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateNotificationResource {
    private Date date;
    private String type;
    private String message;
    private Long businessId;
    private Long studentId;
}
