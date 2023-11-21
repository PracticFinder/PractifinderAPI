package com.practifinder.webapp.practifinder.experience.domain.model;

import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import com.practifinder.webapp.shared.domain.model.AuditModel;
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
    @Column(name = "empresa")
    private String empresa;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "cargo")
    private String cargo;

    @NotNull
    @NotBlank
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechaFinalizacion")
    private Date fechaFinalizacion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechaInicio")
    private Date fechaInicio;

    @ManyToOne
    @JoinColumn(name = "student_id") // specify the foreign key column name
    private Student student;
}
