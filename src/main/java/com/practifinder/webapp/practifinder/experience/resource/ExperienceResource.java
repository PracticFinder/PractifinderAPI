package com.practifinder.webapp.practifinder.experience.resource;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceResource {
    private Long id;
    private String name;
    private String jobPosition;
    private int description;
    private Date fechaFinal;
    private Date fechaInicio;
}
