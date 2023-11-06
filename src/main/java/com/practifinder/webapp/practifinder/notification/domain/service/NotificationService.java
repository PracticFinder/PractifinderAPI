package com.practifinder.webapp.practifinder.notification.domain.service;

import com.practifinder.webapp.practifinder.notification.domain.model.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NotificationService {
    List<Notification> getAll();
    Page<Notification> getAll(Pageable pageable);
    Notification getById(Long notificationId);
    Notification create(Notification notification);
    Notification update(Long notificationId, Notification notification);
    ResponseEntity<?> delete(Long notificationId);
    Notification addStudentToNotification(Long studentId, Long notificationId);

}
