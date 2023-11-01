package com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Knowledge")
public class Knowledge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

}
