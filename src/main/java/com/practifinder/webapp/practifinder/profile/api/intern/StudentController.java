package com.practifinder.webapp.practifinder.profile.api.intern;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.model.SkillInterpersonal;
import com.practifinder.webapp.practifinder.profile.domain.intern.service.StudentService;
import com.practifinder.webapp.practifinder.profile.mapping.intern.StudentMapper;
import com.practifinder.webapp.practifinder.profile.resource.intern.CreateStudentResource;
import com.practifinder.webapp.practifinder.profile.resource.intern.StudentResource;
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

    @PostMapping("/{studentId}/experiences")
    public ResponseEntity<List<Experience>> addExperienceToStudent(@PathVariable Long studentId) {
        List<Experience> experiences = studentService.getExperiencesByStudentId(studentId);
        return ResponseEntity.ok(experiences);
    }

    @GetMapping("/{studentId}/experiences")
    public ResponseEntity<List<Experience>> getStudentExperiences(@PathVariable Long studentId) {
        List<Experience> experiences = studentService.getExperiencesByStudentId(studentId);
        return ResponseEntity.ok(experiences);
    }

    @PostMapping("/{studentId}/skills")
    public ResponseEntity<List<SkillInterpersonal>> addSkillToStudent(@PathVariable Long studentId) {
        List<SkillInterpersonal> skillInterpersonals = studentService.getSkillsByStudentId(studentId);
        return ResponseEntity.ok(skillInterpersonals);
    }

    @GetMapping("/{studentId}/skills")
    public ResponseEntity<List<SkillInterpersonal>> getStudentSkills(@PathVariable Long studentId) {
        List<SkillInterpersonal> skillInterpersonals = studentService.getSkillsByStudentId(studentId);
        return ResponseEntity.ok(skillInterpersonals);
    }

    @PostMapping("/{studentId}/languages")
    public ResponseEntity<List<Language>> addLanguageToStudent(@PathVariable Long studentId) {
        List<Language> languages = studentService.getLanguagesByStudentId(studentId);
        return ResponseEntity.ok(languages);
    }

    @GetMapping("/{studentId}/languages")
    public ResponseEntity<List<Language>> getStudentLanguages(@PathVariable Long studentId) {
        List<Language> languages = studentService.getLanguagesByStudentId(studentId);
        return ResponseEntity.ok(languages);
    }



    @PostMapping("/{studentId}/knowledges")
    public ResponseEntity<List<Knowledge>> addKnowledgeToStudent(@PathVariable Long studentId) {
        List<Knowledge> knowledges = studentService.getKnowledgesByStudentId(studentId);
        return ResponseEntity.ok(knowledges);
    }


    @GetMapping("/{studentId}/knowledges")
    public ResponseEntity<List<Knowledge>> getStudentKnowledges(@PathVariable Long studentId) {
        List<Knowledge> knowledges = studentService.getKnowledgesByStudentId(studentId);
        return ResponseEntity.ok(knowledges);
    }

}
