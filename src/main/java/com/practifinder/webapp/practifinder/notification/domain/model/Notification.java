package com.practifinder.webapp.practifinder.notification.domain.model;

import com.practifinder.webapp.practifinder.profile.domain.business.model.Business;
import com.practifinder.webapp.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="notifications")
public class Notification extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max=255)
    private String type;

    @NotNull
    @NotBlank
    @Size(max=500)
    private String message;

    private Date date;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "business_id",nullable = false)
    private Business business;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "notification")
    private Set<NotificationStudent> studentsListByNotification;

    public Notification addStudent(Notification notification, long studentId){
        if(studentsListByNotification==null) studentsListByNotification=new HashSet<>();
        this.studentsListByNotification.add(new NotificationStudent(this,studentId));

        return this;
    }

}
