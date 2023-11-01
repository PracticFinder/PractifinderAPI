package com.practifinder.webapp.practifinder.profile.api.intern.rest;

import com.practifinder.webapp.practifinder.profile.domain.intern.service.StudentService;
import com.practifinder.webapp.practifinder.profile.mapping.intern.StudentMapper;
import com.practifinder.webapp.practifinder.profile.resource.intern.CreateStudentResource;
import com.practifinder.webapp.practifinder.profile.resource.intern.StudentResource;
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
    @GetMapping("{paymentId}")
    public StudentResource getStudentById(@PathVariable Long paymentId){
        return mapper.toResource(studentService.getById(paymentId));
    }
    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource){
        return  new ResponseEntity<>(mapper.toResource(studentService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
    @DeleteMapping("{paymentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long paymentId){
        return studentService.delete(paymentId);
    }

}
