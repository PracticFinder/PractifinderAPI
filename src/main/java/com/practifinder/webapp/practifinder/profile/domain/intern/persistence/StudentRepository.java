package com.practifinder.webapp.practifinder.profile.domain.intern.persistence;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Experience> findExperiencesById(Long id);

    List<Student> findByNombre(String nombre);

    List<Language> findIdiomasById(Long id);

    Student findByCorreo(String email);

    Student findByUsername(String username);

    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.postulaciones WHERE s.id = :studentId")
    Student findByIdWithPostulaciones(@Param("studentId") Long studentId);

}
