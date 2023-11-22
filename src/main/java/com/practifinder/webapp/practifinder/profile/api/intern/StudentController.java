package com.practifinder.webapp.practifinder.profile.api.intern;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import com.practifinder.webapp.practifinder.intership.domain.offer.service.OfferInternshipStudentService;
import com.practifinder.webapp.practifinder.intership.mapping.offer.OfferIntershipStudentMapper;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferInternshipResource;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.skillTechnical.model.SkillTechnical;
import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.model.SkillInterpersonal;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import com.practifinder.webapp.practifinder.profile.domain.intern.service.StudentService;
import com.practifinder.webapp.practifinder.profile.mapping.intern.StudentMapper;
import com.practifinder.webapp.practifinder.profile.resource.intern.CreateStudentResource;
import com.practifinder.webapp.practifinder.profile.resource.intern.CreateStudentWithAttributesResource;
import com.practifinder.webapp.practifinder.profile.resource.intern.StudentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth/students")
public class StudentController {
    private final StudentService studentService;
    private final OfferInternshipStudentService offerInternshipStudentService;
    private final StudentMapper mapper;

    private final OfferInternshipStudentService offerInternshipService;

    private final OfferIntershipStudentMapper offerIntershipStudentMapper;

    public StudentController(StudentService studentService, StudentMapper mapper,
                             OfferInternshipStudentService offerInternshipStudentService,
                             OfferIntershipStudentMapper offerInternshipStudentMapper,
                             OfferInternshipStudentService offerInternshipService) {
        this.studentService = studentService;
        this.mapper = mapper;
        this.offerInternshipStudentService = offerInternshipStudentService;
        this.offerIntershipStudentMapper = offerInternshipStudentMapper;
        this.offerInternshipService = offerInternshipService;
    }

    @GetMapping
    public Page<StudentResource> getAllStudents(Pageable pageable){

        return mapper.modelListPage(studentService.getAll(), pageable);
    }

    @GetMapping("{studentId}")
    public StudentResource getStudentById(@PathVariable Long studentId){
        return mapper.toResource(studentService.getById(studentId));
    }

    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource){
        return  new ResponseEntity<>(mapper.toResource(studentService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("/{studentId}/createWithMissingAttributes")
    public ResponseEntity<StudentResource> createStudentWithMissingAttributes(
            @PathVariable Long studentId,
            @RequestBody CreateStudentWithAttributesResource createStudentWithAttributesResource) {
        Student createdStudent = studentService.createWithMissingAttributes(studentId, createStudentWithAttributesResource);
        return new ResponseEntity<>(mapper.toResource(createdStudent), HttpStatus.CREATED);
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long studentId){
        return studentService.delete(studentId);
    }


    @PostMapping("/{studentId}/experiences")
    public ResponseEntity<List<Experience>> addExperienceToStudent(
            @PathVariable Long studentId,
            @RequestBody Experience experience) {
        List<Experience> updatedExperiences = studentService.addExperienceToStudent(studentId, experience);
        return ResponseEntity.ok(updatedExperiences);
    }

    @GetMapping("/{studentId}/experiences")
    public ResponseEntity<List<Experience>> getStudentExperiences(@PathVariable Long studentId) {
        List<Experience> experiences = studentService.getExperiencesByStudentId(studentId);
        return ResponseEntity.ok(experiences);
    }

    @PostMapping("/{studentId}/skills_interpersonales")
    public ResponseEntity<List<SkillInterpersonal>> addSkillInterpersonalToStudent(
            @PathVariable Long studentId,
            @RequestBody SkillInterpersonal skillInterpersonal) {
        List<SkillInterpersonal> updatedExperiences = studentService.addSkillInterpersonalToStudent(studentId, skillInterpersonal);
        return ResponseEntity.ok(updatedExperiences);
    }

    @GetMapping("/{studentId}/skills_imterpersonales")
    public ResponseEntity<List<SkillInterpersonal>> getStudentSkills(@PathVariable Long studentId) {
        List<SkillInterpersonal> skillInterpersonals = studentService.getSkillsInterpersonalByStudentId(studentId);
        return ResponseEntity.ok(skillInterpersonals);
    }


    @PostMapping("/{studentId}/skills_technicals")
    public ResponseEntity<List<SkillTechnical>> addSkillTechnicalToStudent(
            @PathVariable Long studentId,
            @RequestBody SkillTechnical skillTechnical) {
        List<SkillTechnical> updatedSkillsTechnicals = studentService.addSkillTechnicalToStudent(studentId, skillTechnical);
        return ResponseEntity.ok(updatedSkillsTechnicals);
    }

    @GetMapping("/{studentId}/skills_technicals")
    public ResponseEntity<List<SkillTechnical>> getStudentSkillsTechnical(@PathVariable Long studentId) {
        List<SkillTechnical> skillTechnicals = studentService.getSkillsTechnicalByStudentId(studentId);
        return ResponseEntity.ok(skillTechnicals);
    }

    @PostMapping("/{studentId}/languages")
    public ResponseEntity<List<Language>> addLanguageToStudent(
            @PathVariable Long studentId,
            @RequestBody Language language) {
        List<Language> updatedLanguages = studentService.addLanguageToStudent(studentId, language);
        return ResponseEntity.ok(updatedLanguages);
    }

    @GetMapping("/{studentId}/languages")
    public ResponseEntity<List<Language>> getStudentLanguages(@PathVariable Long studentId) {
        List<Language> languages = studentService.getLanguagesByStudentId(studentId);
        return ResponseEntity.ok(languages);
    }

    @PostMapping("/{studentId}/knowledges")
    public ResponseEntity<List<Knowledge>> addKnowledgeToStudent(
            @PathVariable Long studentId,
            @RequestBody Knowledge knowledge) {
        List<Knowledge> updatedKnowledges = studentService.addKnowledgeToStudent(studentId, knowledge);
        return ResponseEntity.ok(updatedKnowledges);
    }

    @GetMapping("/{studentId}/knowledges")
    public ResponseEntity<List<Knowledge>> getStudentKnowledges(@PathVariable Long studentId) {
        List<Knowledge> knowledges = studentService.getKnowledgesByStudentId(studentId);
        return ResponseEntity.ok(knowledges);
    }

    @GetMapping("/{studentId}/postulaciones")
    public ResponseEntity<List<OfferInternship>> getPostulaciones(@PathVariable Long studentId) {
        List<OfferInternship> postulaciones = offerInternshipStudentService.getPostulaciones(studentId);
        return ResponseEntity.ok(postulaciones);
    }

    @GetMapping("/profiles/{studentId}/offers")
    public ResponseEntity<List<OfferInternshipResource>> getStudentOffers(@PathVariable Long studentId) {
        List<OfferInternship> offers = offerInternshipService.getPostulaciones(studentId);

        List<OfferInternshipResource> offerResources = offers.stream()
                .map(offerIntershipStudentMapper::toResource)
                .collect(Collectors.toList());

        return ResponseEntity.ok(offerResources);
    }

    @GetMapping("/users_offers")
    public ResponseEntity<List<StudentResource>> getStudentOffers() {
        List<StudentResource> studentOffers = studentService.getAllStudentOffers();
        return ResponseEntity.ok(studentOffers);
    }

}

