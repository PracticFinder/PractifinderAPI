package com.practifinder.webapp.practifinder.experience.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name="experiences")
public class Experience {

    @Id
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
