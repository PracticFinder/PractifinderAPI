package com.practifinder.webapp.practifinder.intership.api.offer;

import com.practifinder.webapp.practifinder.intership.domain.offer.service.OfferInternshipService;
import com.practifinder.webapp.practifinder.intership.mapping.offer.OfferInternshipMapper;
import com.practifinder.webapp.practifinder.intership.resource.offer.CreateOfferInternshipResource;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferInternshipResource;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import com.practifinder.webapp.practifinder.profile.resource.intern.StudentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/offers")
public class OfferInternshipController {

    private final OfferInternshipService offerInternshipService;
    private final OfferInternshipMapper offerInternshipMapper;

    public OfferInternshipController(OfferInternshipService offerInternshipService, OfferInternshipMapper offerInternshipMapper){
        this.offerInternshipService = offerInternshipService;
        this.offerInternshipMapper = offerInternshipMapper;
    }

    @GetMapping
    public Page<OfferInternshipResource> getAllOfferInternship(Pageable pageable){
        return offerInternshipMapper.modelListPage(offerInternshipService.getAll(), pageable);
    }

    @GetMapping("{offerInternshipId}")
    public OfferInternshipResource getOfferInternshipById(@PathVariable Long offerInternshipId){
        return offerInternshipMapper.toResource(offerInternshipService.getById(offerInternshipId));
    }

    @PostMapping
    public ResponseEntity<OfferInternshipResource> createOfferInternship(@RequestBody CreateOfferInternshipResource resource){
        return new ResponseEntity<>( offerInternshipMapper.toResource(offerInternshipService.create(offerInternshipMapper.toModel(resource))), HttpStatus.CREATED);
    }

    @GetMapping("/{offerId}/postulantes")
    public ResponseEntity<List<StudentResource>> getPostulantes(@PathVariable Long offerId) {
        List<Student> postulantes = offerInternshipService.getPostulantes(offerId);
        // Puedes usar un mapper para convertir los objetos de dominio en recursos DTO si es necesario
        List<StudentResource> postulantesResources = mapToStudentResources(postulantes);
        return ResponseEntity.ok(postulantesResources);
    }

    @PostMapping("/{offerId}/postular/{studentId}")
    public ResponseEntity<String> postular(@PathVariable Long offerId, @PathVariable Long studentId) {
        offerInternshipService.postular(offerId, studentId);
        return ResponseEntity.ok("Student with ID " + studentId + " applied successfully to offer with ID " + offerId);
    }

    @DeleteMapping("/{offerId}/retirarPostulacion/{studentId}")
    public ResponseEntity<Void> retirarPostulacion(@PathVariable Long offerId, @PathVariable Long studentId) {
        offerInternshipService.retirarPostulacion(offerId, studentId);
        return ResponseEntity.ok().build();
    }

    private List<StudentResource> mapToStudentResources(List<Student> students) {
        return students.stream()
                .map(student -> new StudentResource(
                        student.getId(),
                        student.getNombre(),
                        student.getCorreo(),
                        student.getUsername(),
                        student.getPassword(),
                        student.getRolId(),
                        student.getImagen(),
                        student.getEdad(),
                        student.getDireccion(),
                        student.getTelefono(),
                        student.getHabilidadesInterpersonales(),
                        student.getHabilidadesTecnicas(),
                        student.getExperiencias(),
                        student.getCertificaciones(),
                        student.getIdiomas()
                ))
                .collect(Collectors.toList());
    }

}
