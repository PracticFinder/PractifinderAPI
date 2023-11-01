package com.practifinder.webapp.practifinder.profile.domain.business.model;

import com.practifinder.webapp.practifinder.notification.domain.model.Notification;
import com.practifinder.webapp.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "business")
public class Business extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String description;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String location;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String siteWeb;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="business")
    private Set<BusinessOffer> offersListByBusiness;


    public Business addOffer(Business business, long offerId){
        if(offersListByBusiness==null) offersListByBusiness=new HashSet<>();
        this.offersListByBusiness.add(new BusinessOffer(this,offerId));

        return this;
    }


}
