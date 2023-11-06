package com.practifinder.webapp.practifinder.notification.domain.service;

import com.practifinder.webapp.practifinder.notification.domain.model.NotificationStudent;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NotificationStudentService {
    List<NotificationStudent> getAll();

    NotificationStudent getById(Long notificationStudentId);

    NotificationStudent create(NotificationStudent notificationStudent);

    ResponseEntity<?> delete(Long notificationStudentId);

    List<NotificationStudent> getAllByStudentId(Long studentId);
}
