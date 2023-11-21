package com.practifinder.webapp.practifinder.profile.resource.intern;


import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.skillTechnical.model.SkillTechnical;
import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.model.SkillInterpersonal;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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

    private List<SkillInterpersonal> habilidadesInterpersonales;

    private List<SkillTechnical> habilidadesTecnicas;

    private List<Experience> experiencias;

    private List<Knowledge> certificaciones;

    private List<Language> idiomas;
}