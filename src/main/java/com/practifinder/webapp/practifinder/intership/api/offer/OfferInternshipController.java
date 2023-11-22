package com.practifinder.webapp.practifinder.intership.api.offer;

import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import com.practifinder.webapp.practifinder.intership.domain.offer.service.OfferInternshipService;
import com.practifinder.webapp.practifinder.intership.domain.offer.service.OfferInternshipStudentService;
import com.practifinder.webapp.practifinder.intership.mapping.offer.OfferIntershipStudentMapper;
import com.practifinder.webapp.practifinder.intership.resource.offer.CreateOfferInternshipResource;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferInternshipResource;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferInternshipStudentsResource;
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
    private final OfferIntershipStudentMapper offerIntershipStudentMapper;

    private final OfferInternshipStudentService offerInternshipStudentService;

    public OfferInternshipController(OfferInternshipService offerInternshipService, OfferIntershipStudentMapper offerIntershipStudentMapper
            , OfferInternshipStudentService offerInternshipStudentService){
        this.offerInternshipService = offerInternshipService;
        this.offerIntershipStudentMapper = offerIntershipStudentMapper;
        this.offerInternshipStudentService = offerInternshipStudentService;
    }

    @GetMapping
    public Page<OfferInternshipResource> getAllOfferInternship(Pageable pageable){
        return offerIntershipStudentMapper.modelListPage(offerInternshipService.getAll(), pageable);
    }

    @GetMapping("{offerInternshipId}")
    public OfferInternshipResource getOfferInternshipById(@PathVariable Long offerInternshipId){
        return offerIntershipStudentMapper.toResource(offerInternshipService.getById(offerInternshipId));
    }

    @PostMapping
    public ResponseEntity<OfferInternshipResource> createOfferInternship(@RequestBody CreateOfferInternshipResource resource){
        return new ResponseEntity<>( offerIntershipStudentMapper.toResource(offerInternshipService.create(resource)), HttpStatus.CREATED);
    }

    @GetMapping("/offers_with_student")
    public ResponseEntity<List<OfferInternshipStudentsResource>> getAllOffersWithStudent() {
        List<OfferInternship> offers = offerInternshipService.getAll();
        List<OfferInternshipStudentsResource> offersWithStudent = offers.stream().map(offer -> {
            OfferInternshipStudentsResource offerWithStudent = offerIntershipStudentMapper.toResource_(offer);
            List<StudentResource> postulantes = offerInternshipService.getPostulantesByOfferId(offer.getId());
            offerWithStudent.setPostulantes(postulantes);
            return offerWithStudent;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(offersWithStudent);
    }

    @GetMapping("/{offerId}/postulantes")
    public ResponseEntity<List<Student>> getPostulantes(@PathVariable Long offerId) {
        List<Student> postulantes = offerInternshipStudentService.getPostulantes(offerId);
        return ResponseEntity.ok(postulantes);
    }

    @GetMapping("/{studentId}/postulaciones")
    public ResponseEntity<List<OfferInternship>> getPostulaciones(@PathVariable Long studentId) {
        List<OfferInternship> postulaciones = offerInternshipStudentService.getPostulaciones(studentId);
        return ResponseEntity.ok(postulaciones);
    }

    @GetMapping("/{offerId}/postulantes/{studentId}")
    public ResponseEntity<StudentResource> getStudent(@PathVariable Long offerId, @PathVariable Long studentId) {
        StudentResource student = offerInternshipStudentService.getStudent(offerId, studentId);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{offerId}")
    public ResponseEntity<OfferInternship> getOffer(@PathVariable Long offerId) {
        OfferInternship offer = offerInternshipService.getById(offerId);
        return ResponseEntity.ok(offer);
    }

    @PostMapping("/{offerId}/postulantes/{studentId}")
    public ResponseEntity<?> registerStudentForOffer(@PathVariable Long offerId, @PathVariable Long studentId) {
        offerInternshipStudentService.registerStudentForOffer(offerId, studentId);
        return ResponseEntity.ok().build();
    }

}
