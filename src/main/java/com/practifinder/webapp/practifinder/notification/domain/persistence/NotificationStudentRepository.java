package com.practifinder.webapp.practifinder.notification.domain.persistence;

import com.practifinder.webapp.practifinder.notification.domain.model.Notification;
import com.practifinder.webapp.practifinder.notification.domain.model.NotificationStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotificationStudentRepository extends JpaRepository<NotificationStudent, Long> {
    List<NotificationStudent> findAllByNotification(Optional<Notification> notification);
}
