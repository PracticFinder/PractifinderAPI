package com.practifinder.webapp.practifinder.notification.resource;

import com.practifinder.webapp.practifinder.notification.domain.model.NotificationStudent;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class NotificationResource {
    private Long id;
    private String type;
    private String message;
    private Date date;
    private Set<NotificationStudent> studentsListByNotification;
}
