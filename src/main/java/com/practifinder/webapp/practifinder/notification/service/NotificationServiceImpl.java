package com.practifinder.webapp.practifinder.notification.service;

import com.practifinder.webapp.practifinder.notification.domain.model.Notification;
import com.practifinder.webapp.practifinder.notification.domain.persistence.NotificationRepository;
import com.practifinder.webapp.practifinder.notification.domain.service.NotificationService;
import com.practifinder.webapp.shared.exception.ResourceNotFoundException;
import com.practifinder.webapp.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final String ENTITY = "Notification";

    private final NotificationRepository notificationRepository;

    private final Validator validator;
    public NotificationServiceImpl(NotificationRepository notificationRepository, Validator validator) {
        this.notificationRepository = notificationRepository;
        this.validator = validator;
    }

    @Override
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Page<Notification> getAll(Pageable pageable) {
        return notificationRepository.findAll(pageable);
    }

    @Override
    public Notification getById(Long notificationId) {
        return notificationRepository.findById(notificationId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, notificationId));
    }

    @Override
    public Notification create(Notification notification) {
        Set<ConstraintViolation<Notification>> violations = validator.validate(notification);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        Notification notification1 = notificationRepository.findByDate(notification.getDate());
        return notificationRepository.save(notification);
    }

    @Override
    public Notification update(Long id, Notification notification) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long notificationId) {
        return notificationRepository.findById(notificationId).map(notification -> {
            notificationRepository.delete(notification);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, notificationId));
    }

    @Override
    public Notification addStudentToNotification(Long studentId, Long notificationId) {
        return null;
    }


}
