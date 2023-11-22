package com.practifinder.webapp.practifinder.lifescape.resource.skillTechnical;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSkillTechnicalResource {
    @NotNull
    @NotBlank
    @Size(max=20)
    private String name;

    @NotNull
    private Long studentId;
}
