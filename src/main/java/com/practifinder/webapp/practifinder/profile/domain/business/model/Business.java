package com.practifinder.webapp.practifinder.profile.domain.business.model;


import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.util.List;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "business")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "username", unique = true)
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 120)
    @Column(name = "password")
    private String password;

    @NotNull
    @Email
    @Column(name = "correo")
    private String correo;

    @NotNull
    @Column(name = "rolId")
    private Long rolId;


    @ElementCollection
    @CollectionTable(name = "empresa_locations", joinColumns = @JoinColumn(name = "empresa_id"))
    @Column(name = "location")
    private List<String> locations;


    @Column(name = "imagen")
    @URL
    private String imagen;


    @Size(max = 200)
    @Column(name = "siteWeb")
    private String siteWeb;

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OfferInternship> ofertas;



}
