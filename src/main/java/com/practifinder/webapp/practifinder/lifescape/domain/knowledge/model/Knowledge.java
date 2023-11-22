package com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model;


import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
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
@Table(name="knowledge")
public class Knowledge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max=100)
    @Column(name = "name")
    private String nombre;

    @NotNull
    @NotBlank
    @Size(max=100)
    @Column(name = "nombreInstitucion")
    private String nombreInstitucion;

    @NotNull
    @NotBlank
    @Column(name = "fechaObtencion")
    private Date fechaObtencion;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}

