package com.practifinder.webapp.practifinder.notification.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name="notification_student")
public class NotificationStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "notification_id",nullable = false)
    @JsonIgnore
    private Notification notification;

    private Long studentId;

    public NotificationStudent(Notification notification, Long studentId) {
        this.notification = notification;
        this.studentId = studentId;
    }

}
