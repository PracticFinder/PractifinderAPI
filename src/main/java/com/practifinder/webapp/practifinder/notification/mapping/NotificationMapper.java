package com.practifinder.webapp.practifinder.notification.mapping;

import com.practifinder.webapp.practifinder.notification.domain.model.Notification;
import com.practifinder.webapp.practifinder.notification.resource.CreateNotificationResource;
import com.practifinder.webapp.practifinder.notification.resource.NotificationResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class NotificationMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public NotificationResource toResource(Notification model){
        return mapper.map(model, NotificationResource.class);
    }

    public Page<NotificationResource> modelListPage(List<Notification> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, NotificationResource.class), pageable, modelList.size());
    }

    public Notification toModel(CreateNotificationResource resource){
        return mapper.map(resource, Notification.class);
    }



}
