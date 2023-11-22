package com.practifinder.webapp.practifinder.lifescape.resource.skillInterpersonal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateSkillInterpersonalResource {
    @NotNull
    @NotBlank
    @Size(max=20)
    private String name;

    @NotNull
    private Long studentId;
}
