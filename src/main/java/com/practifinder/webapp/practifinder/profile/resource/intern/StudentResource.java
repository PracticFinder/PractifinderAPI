package com.practifinder.webapp.practifinder.profile.resource.intern;


import com.practifinder.webapp.practifinder.experience.resource.ExperienceResource;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferInternshipResource;
import com.practifinder.webapp.practifinder.lifescape.resource.knowledge.KnowledgeResource;
import com.practifinder.webapp.practifinder.lifescape.resource.language.LanguageResource;
import com.practifinder.webapp.practifinder.lifescape.resource.skillInterpersonal.SkillInterpersonalResource;
import com.practifinder.webapp.practifinder.lifescape.resource.skillTechnical.SkillTechnicalResource;
import lombok.*;

import java.util.List;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class StudentResource {
    private Long id;

    private String nombre;

    private String correo;

    private String username;

    private String password;

    private Long rolId;

    private String imagen;

    private int edad;

    private String direccion;

    private String telefono;



    private List<OfferInternshipResource> postulaciones;

    private List<SkillInterpersonalResource> habilidadesInterpersonales;

    private List<SkillTechnicalResource> habilidadesTecnicas;

    private List<ExperienceResource> experiencias;

    private List<KnowledgeResource> certificaciones;

    private List<LanguageResource> idiomas;



}