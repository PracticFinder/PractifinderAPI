package com.practifinder.webapp.practifinder.experience.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceResource {
    private Long id;
    private String name;
    private String jobPosition;
    private int description;
    private Date dateFinal;
    private Date dateInit;
}

