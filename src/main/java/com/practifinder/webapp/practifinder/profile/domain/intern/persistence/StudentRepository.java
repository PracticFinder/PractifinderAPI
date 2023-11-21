package com.practifinder.webapp.practifinder.profile.domain.intern.persistence;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Experience> findExperiencesById(Long id);

    Student findByCorreo(String email);

}
