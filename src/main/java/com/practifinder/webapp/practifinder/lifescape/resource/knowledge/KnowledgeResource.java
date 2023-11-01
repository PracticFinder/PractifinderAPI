package com.practifinder.webapp.practifinder.lifescape.resource.knowledge;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgeResource {
    private Long id;
    private String name;
    private String nameInstitution;
    private Date dateObtained;
}

