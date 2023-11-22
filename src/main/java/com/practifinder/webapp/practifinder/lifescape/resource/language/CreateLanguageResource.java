package com.practifinder.webapp.practifinder.lifescape.resource.language;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor

public class CreateLanguageResource {

    @NotNull
    @NotBlank
    @Size(max=20)
    private String name;

    @NotNull
    @NotBlank
    @Size(max=200)
    private String description;

    @NotNull
    private Long studentId;
}
