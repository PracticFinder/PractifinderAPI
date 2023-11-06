package com.practifinder.webapp.practifinder.intership.resource.requirement;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRequirementResource {
    private Long id;

    @NotNull
    @NotBlank
    @Size(max=255)
    private String description;
}
