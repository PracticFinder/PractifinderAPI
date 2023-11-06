package com.practifinder.webapp.practifinder.experience.resource;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateExperienceResource {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String jobPosition;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private int description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFinal;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateInit;
}
