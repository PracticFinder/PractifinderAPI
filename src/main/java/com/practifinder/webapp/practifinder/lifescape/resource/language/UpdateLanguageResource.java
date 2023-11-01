package com.practifinder.webapp.practifinder.lifescape.resource.language;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLanguageResource {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max=20)
    private String name;

    @NotNull
    @NotBlank
    @Size(max=200)
    private String description;
}
