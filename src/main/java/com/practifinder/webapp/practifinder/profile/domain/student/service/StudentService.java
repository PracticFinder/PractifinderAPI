package com.practifinder.webapp.practifinder.profile.domain.student.service;

import com.practifinder.webapp.practifinder.profile.domain.student.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    Page<Student> getAll(Pageable pageable);

    Student getById(Long studenId);

    Student create(Student student);

    Student update(Long id, Student student);

    ResponseEntity<?> delete(Long studentId);
    Student getApplicantWithExperiences(Long applicantId);
}