package com.practifinder.webapp.practifinder.profile.service.intern;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.experience.domain.persistence.ExperienceRepository;
import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferInternshipResource;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.persistence.KnowledgeRepository;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.language.persistence.LanguageRepository;
import com.practifinder.webapp.practifinder.lifescape.domain.skillTechnical.model.SkillTechnical;
import com.practifinder.webapp.practifinder.lifescape.domain.skillTechnical.repository.SkillTechnicalRepository;
import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.model.SkillInterpersonal;
import com.practifinder.webapp.practifinder.lifescape.domain.skillinterpersonal.persistence.SkillInterpersonalRepository;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import com.practifinder.webapp.practifinder.profile.domain.intern.persistence.StudentRepository;
import com.practifinder.webapp.practifinder.profile.domain.intern.service.StudentService;
import com.practifinder.webapp.practifinder.profile.resource.intern.CreateStudentWithAttributesResource;
import com.practifinder.webapp.practifinder.profile.resource.intern.StudentResource;
import com.practifinder.webapp.shared.exception.ResourceNotFoundException;
import com.practifinder.webapp.shared.exception.ResourceValidationException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private static final String ENTITY = "Student";
    private final Validator validator;
    private final StudentRepository studentRepository;
    private final ExperienceRepository experienceRepository;
    private final KnowledgeRepository knowledgeRepository;
    private final LanguageRepository languageRepository;
    private final SkillInterpersonalRepository skillInterpersonalRepository;
    private final SkillTechnicalRepository skillTechnicalRepository;



    public StudentServiceImpl(StudentRepository studentRepository,
                              Validator validator,
                              ExperienceRepository experienceRepository,
                              KnowledgeRepository knowledgeRepository,
                              LanguageRepository languageRepository,
                              SkillInterpersonalRepository skillInterpersonalRepository,
                              SkillTechnicalRepository skillTechnicalRepository) {
        this.studentRepository= studentRepository;
        this.experienceRepository = experienceRepository;
        this.knowledgeRepository = knowledgeRepository;
        this.languageRepository = languageRepository;
        this.skillInterpersonalRepository = skillInterpersonalRepository;
        this.skillTechnicalRepository = skillTechnicalRepository;
        this.validator = validator;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student getById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, studentId));
    }

    @Override
    public Student create(Student student) {
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Student studentWithEmail = studentRepository.findByCorreo(student.getCorreo());

        if(studentWithEmail != null)
            throw new ResourceValidationException(ENTITY,
                    "A student with the same email already exists.");

        if(student.getImagen() == null)
            student.setImagen("https://i.ibb.co/7tBZVw7/Logo-Practifinder.png");

        return studentRepository.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Student studentWithEmail = studentRepository.findByCorreo(student.getCorreo());

        if(studentWithEmail != null && !studentWithEmail.getId().equals(id))
            throw new ResourceValidationException(ENTITY,
                    "A student with the same email already exists.");

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));

        existingStudent.setNombre(student.getNombre());
        existingStudent.setCorreo(student.getCorreo());
        existingStudent.setEdad(student.getEdad());
        existingStudent.setImagen(student.getImagen());
        existingStudent.setDireccion(student.getDireccion());
        existingStudent.setTelefono(student.getTelefono());
        existingStudent.setUsername(student.getUsername());
        existingStudent.setPassword(student.getPassword());
        existingStudent.setRolId(student.getRolId());
        existingStudent.setPostulaciones(student.getPostulaciones());
        existingStudent.setHabilidadesInterpersonales(student.getHabilidadesInterpersonales());
        existingStudent.setHabilidadesTecnicas(student.getHabilidadesTecnicas());
        existingStudent.setExperiencias(student.getExperiencias());
        existingStudent.setCertificaciones(student.getCertificaciones());
        existingStudent.setIdiomas(student.getIdiomas());

        if(student.getImagen() == null)
            student.setImagen("https://i.ibb.co/7tBZVw7/Logo-Practifinder.png");

        return studentRepository.save(existingStudent);
    }

    @Override
    public ResponseEntity<?> delete(Long studentId) {
        return studentRepository.findById(studentId).map(student ->{
                    studentRepository.delete(student);
                    return ResponseEntity.ok().build();})
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,studentId));
    }

    @Override
    public List<Experience> getExperiencesByStudentId(Long studentId){
        List<Experience> experiences = experienceRepository.findByStudentId(studentId);
        if (experiences == null || experiences.isEmpty()) {
            throw new EntityNotFoundException("Experiences not found for student with ID: " + studentId);
        }
        return experiences;
    }

    @Override
    public List<Language> getLanguagesByStudentId(Long studentId) {
        List<Language> languages = languageRepository.findByStudentId(studentId);
        if (languages == null || languages.isEmpty()) {
            throw new EntityNotFoundException("Languages not found for student with ID: " + studentId);
        }
        return languages;
    }

    @Override
    public List<SkillInterpersonal> getSkillsInterpersonalByStudentId(Long studentId) {
        List<SkillInterpersonal> skillInterpersonals = skillInterpersonalRepository.findByStudentId(studentId);
        if (skillInterpersonals == null || skillInterpersonals.isEmpty()) {
            throw new EntityNotFoundException("Skill Interpersonals not found for student with ID: " + studentId);
        }
        return skillInterpersonals;
    }

    @Override
    public List<SkillTechnical> getSkillsTechnicalByStudentId(Long studentId) {
        List<SkillTechnical> skillTechnicals = skillTechnicalRepository.findByStudentId(studentId);
        if (skillTechnicals == null || skillTechnicals.isEmpty()) {
            throw new EntityNotFoundException("Skill Technicals not found for student with ID: " + studentId);
        }
        return skillTechnicals;
    }

    @Override
    public Student createWithMissingAttributes(Long studentId, CreateStudentWithAttributesResource createStudentWithAttributesResource) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", studentId));

        student.setNombre(student.getNombre());
        student.setCorreo(student.getCorreo());
        student.setUsername(student.getUsername());
        student.setPassword(student.getPassword());
        student.setRolId(student.getRolId());
        student.setEdad(createStudentWithAttributesResource.getEdad());
        student.setImagen(createStudentWithAttributesResource.getImagen());
        student.setDireccion(createStudentWithAttributesResource.getDireccion());
        student.setTelefono(createStudentWithAttributesResource.getTelefono());

        if(student.getImagen() == null)
            student.setImagen("https://i.ibb.co/7tBZVw7/Logo-Practifinder.png");

        return studentRepository.save(student);
    }

    @Override
    public List<Knowledge> getKnowledgesByStudentId(Long studentId) {
        List<Knowledge> knowledges = knowledgeRepository.findByStudentId(studentId);
        if (knowledges == null || knowledges.isEmpty()) {
            throw new EntityNotFoundException("Knowledges not found for student with ID: " + studentId);
        }
        return knowledges;
    }

    @Override
    public List<Experience> addExperienceToStudent(Long studentId, Experience experience) {
        Student student = getById(studentId);

        experience.setStudent(student);

        student.getExperiencias().add(experience);

        studentRepository.save(student);

        return student.getExperiencias();
    }

    @Override
    public List<SkillInterpersonal> addSkillInterpersonalToStudent(Long studentId, SkillInterpersonal skillInterpersonal) {
        Student student = getById(studentId);

        skillInterpersonal.setStudent(student);

        student.getHabilidadesInterpersonales().add(skillInterpersonal);

        studentRepository.save(student);

        return student.getHabilidadesInterpersonales();
    }

    @Override
    public List<SkillTechnical> addSkillTechnicalToStudent(Long studentId, SkillTechnical skillTechnical) {
        Student student = getById(studentId);

        skillTechnical.setStudent(student);

        student.getHabilidadesTecnicas().add(skillTechnical);

        studentRepository.save(student);

        return student.getHabilidadesTecnicas();
    }

    @Override
    public List<Knowledge> addKnowledgeToStudent(Long studentId, Knowledge knowledge) {
        Student student = getById(studentId);

        knowledge.setStudent(student);

        student.getCertificaciones().add(knowledge);

        studentRepository.save(student);

        return student.getCertificaciones();
    }

    @Override
    public List<Language> addLanguageToStudent(Long studentId, Language language) {
        Student student = getById(studentId);

        language.setStudent(student);

        student.getIdiomas().add(language);

        studentRepository.save(student);

        return student.getIdiomas();
    }

    @Override
    public List<StudentResource> getAllStudentOffers() {
        List<Student> students = studentRepository.findAll(); // Obtener todos los estudiantes

        List<StudentResource> studentOffers = students.stream()
                .map(this::mapStudentToResourceWithOffers) // Mapear cada estudiante a StudentResource
                .collect(Collectors.toList());

        return studentOffers;
    }

    private StudentResource mapStudentToResourceWithOffers(Student student) {
        // Puedes mapear los campos básicos del estudiante
        StudentResource studentResource = mapStudentToResource(student);

        // Mapear las ofertas de prácticas del estudiante
        List<OfferInternshipResource> offerResources = student.getPostulaciones().stream()
                .map(offerIntershipStudent -> mapOfferToResource(offerIntershipStudent.getOffer()))
                .collect(Collectors.toList());

        studentResource.setPostulaciones(offerResources);

        return studentResource;
    }

    private StudentResource mapStudentToResource(Student student) {
        // Implementa la lógica de mapeo de Student a StudentResource
        // ...

        // Ejemplo manual, ajusta según tus necesidades
        StudentResource studentResource = new StudentResource();
        studentResource.setId(student.getId());
        studentResource.setNombre(student.getNombre());
        studentResource.setImagen(student.getImagen());
        studentResource.setEdad(student.getEdad());
        studentResource.setTelefono(student.getTelefono());
        studentResource.setDireccion(student.getDireccion());
        studentResource.setCorreo(student.getCorreo());

        // Mapea otras propiedades del estudiante...

        return studentResource;
    }


    private OfferInternshipResource mapOfferToResource(OfferInternship offer) {
        // Implementa la lógica de mapeo de OfferInternship a OfferInternshipResource
        // ...

        // Ejemplo manual, ajusta según tus necesidades
        OfferInternshipResource offerResource = new OfferInternshipResource();
        offerResource.setId(offer.getId());
        offerResource.setTitulo(offer.getTitulo());
        // Mapea otros campos...

        return offerResource;
    }


}