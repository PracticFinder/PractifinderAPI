package com.practifinder.webapp.practifinder.notification.api;

import com.practifinder.webapp.practifinder.notification.domain.service.NotificationService;
import com.practifinder.webapp.practifinder.notification.mapping.NotificationMapper;
import com.practifinder.webapp.practifinder.notification.resource.CreateNotificationResource;
import com.practifinder.webapp.practifinder.notification.resource.NotificationResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    private final NotificationMapper mapper;

    public NotificationController(NotificationService notificationService, NotificationMapper mapper) {
        this.notificationService = notificationService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<NotificationResource> getAllNotifications(Pageable pageable){
        return mapper.modelListPage(notificationService.getAll(), pageable);
    }

    @GetMapping("{notificationId}")
    public NotificationResource getNotificationById(@PathVariable Long notificationId){
        return mapper.toResource(notificationService.getById(notificationId));
    }

    @PostMapping
    public ResponseEntity<NotificationResource> createNotification(@RequestBody CreateNotificationResource resource){
        return new ResponseEntity<>(mapper.toResource(notificationService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @DeleteMapping("{notificationId}")
    public ResponseEntity<?> deleteNotification(@PathVariable Long notificationId){
        return notificationService.delete(notificationId);
    }

}
