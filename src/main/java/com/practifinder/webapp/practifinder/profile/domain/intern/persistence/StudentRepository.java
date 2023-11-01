package com.practifinder.webapp.practifinder.profile.domain.intern.persistence;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
