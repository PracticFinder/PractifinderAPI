package com.practifinder.webapp.practifinder.profile.api.student.rest;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.skill.model.Skill;
import com.practifinder.webapp.practifinder.profile.domain.student.model.Student;
import com.practifinder.webapp.practifinder.profile.domain.student.service.StudentService;
import com.practifinder.webapp.practifinder.profile.mapping.student.StudentMapper;
import com.practifinder.webapp.practifinder.profile.resource.student.CreateStudentResource;
import com.practifinder.webapp.practifinder.profile.resource.student.StudentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper mapper;


    public StudentController(StudentService studentService, StudentMapper mapper) {
        this.studentService = studentService;
        this.mapper = mapper;
    }


    @GetMapping
    public Page<StudentResource> getAllStudents(Pageable pageable){
        return mapper.modelListPage(studentService.getAll(), pageable);
    }
    @GetMapping("{studentId}")
    public StudentResource getStudentById(@PathVariable Long paymentId){
        return mapper.toResource(studentService.getById(paymentId));
    }
    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource){
        return  new ResponseEntity<>(mapper.toResource(studentService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
    @DeleteMapping("{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long studentId){
        return studentService.delete(studentId);
    }


    @GetMapping("/{studentId}/experiences")
    public ResponseEntity<List<Experience>> getStudentExperiences(@PathVariable Long studentId) {
        List<Experience> experiences = studentService.getExperiencesByStudentId(studentId);
        return ResponseEntity.ok(experiences);
    }

    @GetMapping("/{studentId}/skills")
    public ResponseEntity<List<Skill>> getStudentSkills(@PathVariable Long studentId) {
        List<Skill> skills = studentService.getSkillsByStudentId(studentId);
        return ResponseEntity.ok(skills);
    }

    @GetMapping("/{studentId}/languages")
    public ResponseEntity<List<Language>> getStudentLanguages(@PathVariable Long studentId) {
        List<Language> languages = studentService.getLanguagesByStudentId(studentId);
        return ResponseEntity.ok(languages);
    }
}
