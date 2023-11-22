package com.practifinder.webapp.practifinder.lifescape.resource.knowledge;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateKnowledgeResource {

    @NotNull
    @NotBlank
    @Size(max=100)
    private String name;

    @NotNull
    @NotBlank
    @Size(max=100)
    private String nameInstitution;

    @NotNull
    @NotBlank
    private Date dateObtained;

    @NotNull
    private Long studentId;
}