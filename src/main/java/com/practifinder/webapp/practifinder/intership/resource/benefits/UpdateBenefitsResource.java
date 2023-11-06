package com.practifinder.webapp.practifinder.intership.resource.benefits;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBenefitsResource {
    private Long id;
    @NotNull
    @NotBlank
    @Size(max=255)
    private String description;

    @NotNull
    @NotBlank
    private Double salary;
}
