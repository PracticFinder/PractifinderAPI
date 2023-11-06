package com.practifinder.webapp.practifinder.intership.resource.functionality;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateFunctionalityResource {
    @NotNull
    @NotBlank
    private String description;
}
