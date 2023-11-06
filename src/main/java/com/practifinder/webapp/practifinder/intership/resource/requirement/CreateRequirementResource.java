package com.practifinder.webapp.practifinder.intership.resource.requirement;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequirementResource {

    @NotNull
    @NotBlank
    @Size(max=255)
    private String description;
}
