package com.practifinder.webapp.practifinder.intership.resource.functionality;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateFunctionalityResource {
    private Long id;

    @NotNull
    @NotBlank
    private String description;
}
