package com.practifinder.webapp.practifinder.notification.domain.persistence;

import com.practifinder.webapp.practifinder.notification.domain.model.Notification;
import com.practifinder.webapp.practifinder.profile.domain.business.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Notification findByType(String type);
    List<Notification> findAllByBusiness(Business business);

    Notification findByDate(Date date);
}
