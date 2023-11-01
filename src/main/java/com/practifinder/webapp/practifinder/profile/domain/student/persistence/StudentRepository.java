package com.practifinder.webapp.practifinder.profile.domain.student.persistence;
import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.profile.domain.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{
    List<Experience> findExperiencesByApplicantId(Long applicantId);

}
