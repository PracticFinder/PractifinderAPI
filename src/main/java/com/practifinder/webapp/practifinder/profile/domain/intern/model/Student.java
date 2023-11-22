package com.practifinder.webapp.practifinder.profile.domain.intern.model;


import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternshipStudent;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.skillTechnical.model.SkillTechnical;
import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.model.SkillInterpersonal;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name = "nombre", unique = true)
    private String nombre;

    @NotNull
    @Email
    @Column(name = "correo")
    private String correo;

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
    @Column(name = "rolId")
    private Long rolId;



    @Column(name = "imagen")
    @URL
    private String imagen;


    @Column(name = "edad")
    private int edad;


    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;


    @Size(max=12)
    @Column(name = "telefono")
    private String telefono;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    private List<SkillInterpersonal> habilidadesInterpersonales;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    private List<SkillTechnical> habilidadesTecnicas;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    private List<Experience> experiencias;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    private List<Knowledge> certificaciones;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    private List<Language> idiomas;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    private List<OfferInternshipStudent> postulaciones;
}
