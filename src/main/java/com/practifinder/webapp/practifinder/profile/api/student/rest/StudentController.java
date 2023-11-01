package com.practifinder.webapp.practifinder.profile.api.student.rest;

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
    public ResponseEntity<?> deleteStudent(@PathVariable Long paymentId){
        return studentService.delete(paymentId);
    }


    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getApplicant(@PathVariable Long studentId) {
        Student student = studentService.getApplicantWithExperiences(studentId);
        return ResponseEntity.ok(student);
    }

}
