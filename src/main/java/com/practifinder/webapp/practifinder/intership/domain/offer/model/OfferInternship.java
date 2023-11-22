package com.practifinder.webapp.practifinder.intership.domain.offer.model;



import com.practifinder.webapp.practifinder.profile.domain.business.model.Business;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "offer_intership")
public class OfferInternship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "titulo")
    private String titulo;

    @NotNull
    @NotBlank
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @NotNull
    @Column(name = "fecha_fin")
    private Date fechaFin;

    @NotNull
    @NotBlank
    @Size(max = 80)
    @Column(name = "requisitos")
    private String requisitos;

    @NotNull
    @NotBlank
    @Size(max = 80)
    @Column(name = "funciones")
    private String funciones;

    @NotNull
    @NotBlank
    @Size(max = 80)
    @Column(name = "beneficios")
    private String beneficios;


    @NotNull
    @Column(name = "more")
    private Boolean more;

    @NotNull
    @NotBlank
    @Size(max = 80)
    @Column(name = "area")
    private String area;

    @NotNull
    @NotBlank
    @Size(max = 80)
    @Column(name = "ubicacion")
    private String ubicacion;

    @NotNull
    @Column(name = "salario")
    private Double salario;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "offer")
    private List<OfferInternshipStudent> postulantes;

}
