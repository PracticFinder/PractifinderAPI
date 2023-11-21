package com.practifinder.webapp.practifinder.lifescape.resource.skillTechnical;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateSkillTechnicalResource {
    @NotNull
    @NotBlank
    @Size(max=20)
    private String name;
}
