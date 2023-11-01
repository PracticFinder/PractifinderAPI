package com.practifinder.webapp.practifinder.lifescape.resource.language;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class LanguageResource {
    private Long id;
    private String name;
    private String description;
}