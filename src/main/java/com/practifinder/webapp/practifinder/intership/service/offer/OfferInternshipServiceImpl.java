package com.practifinder.webapp.practifinder.intership.service.offer;


import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import com.practifinder.webapp.practifinder.intership.domain.offer.persistence.OfferInternshipRepository;
import com.practifinder.webapp.practifinder.intership.domain.offer.service.OfferInternshipService;
import com.practifinder.webapp.practifinder.intership.resource.offer.CreateOfferInternshipResource;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferInternshipResource;
import com.practifinder.webapp.practifinder.intership.resource.offer.UpdateOfferInternshipResource;
import com.practifinder.webapp.practifinder.profile.domain.business.model.Business;
import com.practifinder.webapp.practifinder.profile.domain.business.service.BusinessService;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import com.practifinder.webapp.practifinder.profile.resource.intern.StudentResource;
import com.practifinder.webapp.shared.exception.ResourceNotFoundException;
import com.practifinder.webapp.shared.exception.ResourceValidationException;
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
public class OfferInternshipServiceImpl implements OfferInternshipService {
    private static final String ENTITY = "OfferInternship";
    private final OfferInternshipRepository offerInternshipRepository;

    private final BusinessService businessService;

    private final Validator validator;

    public OfferInternshipServiceImpl(OfferInternshipRepository offerInternshipRepository, Validator validator
    , BusinessService businessService){
        this.offerInternshipRepository = offerInternshipRepository;
        this.validator = validator;
        this.businessService = businessService;
    }

    @Override
    public List<OfferInternship> getAll() {
        return offerInternshipRepository.findAll();
    }

    @Override
    public Page<OfferInternship> getAll(Pageable pageable) {
        return offerInternshipRepository.findAll(pageable);
    }

    @Override
    public OfferInternship getById(Long offerInternshipId) {
        return offerInternshipRepository.findById(offerInternshipId).orElseThrow(()-> new ResourceNotFoundException(ENTITY, offerInternshipId));
    }


    @Override
    public OfferInternship create(CreateOfferInternshipResource offerInternship) {
        Set<ConstraintViolation<CreateOfferInternshipResource>> violations = validator.validate(offerInternship);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        OfferInternship offerInternshipWithTitle = offerInternshipRepository.findByTitulo(offerInternship.getTitulo());

        if (offerInternshipWithTitle != null)
            throw new ResourceValidationException(ENTITY, "title already exists");

        Business business = businessService.getById(offerInternship.getBusinessId());

        OfferInternship offerInternshipToCreate = new OfferInternship();

        offerInternshipToCreate.setTitulo(offerInternship.getTitulo());
        offerInternshipToCreate.setDescripcion(offerInternship.getDescripcion());
        offerInternshipToCreate.setFechaInicio(offerInternship.getFechaInicio());
        offerInternshipToCreate.setFechaFin(offerInternship.getFechaFin());
        offerInternshipToCreate.setRequisitos(offerInternship.getRequisitos());
        offerInternshipToCreate.setFunciones(offerInternship.getFunciones());
        offerInternshipToCreate.setBeneficios(offerInternship.getBeneficios());
        offerInternshipToCreate.setMore(offerInternship.getMore());
        offerInternshipToCreate.setArea(offerInternship.getArea());
        offerInternshipToCreate.setUbicacion(offerInternship.getUbicacion());
        offerInternshipToCreate.setSalario(offerInternship.getSalario());
        offerInternshipToCreate.setBusiness(business);
        return offerInternshipRepository.save(offerInternshipToCreate);
    }

    @Override
    public OfferInternship update(Long offerInternshipId, OfferInternship offerInternship) {
        Set<ConstraintViolation<OfferInternship>> violations = validator.validate(offerInternship);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        OfferInternship offerInternshipWithTitle = offerInternshipRepository.findByTitulo(offerInternship.getTitulo());

        if (offerInternshipWithTitle != null && !offerInternshipWithTitle.getId().equals(offerInternshipId))
            throw new ResourceValidationException(ENTITY, "title already exists");

        return offerInternshipRepository.findById(offerInternshipId)
                .map(offerInternshipToUpdate -> {
                    offerInternshipToUpdate.setId(offerInternship.getId());
                    offerInternshipToUpdate.setTitulo(offerInternship.getTitulo());
                    offerInternshipToUpdate.setDescripcion(offerInternship.getDescripcion());
                    offerInternshipToUpdate.setFechaInicio(offerInternship.getFechaInicio());
                    offerInternshipToUpdate.setFechaFin(offerInternship.getFechaFin());
                    offerInternshipToUpdate.setRequisitos(offerInternship.getRequisitos());
                    offerInternshipToUpdate.setFunciones(offerInternship.getFunciones());
                    offerInternshipToUpdate.setBeneficios(offerInternship.getBeneficios());
                    offerInternshipToUpdate.setMore(offerInternship.getMore());
                    offerInternshipToUpdate.setArea(offerInternship.getArea());
                    offerInternshipToUpdate.setUbicacion(offerInternship.getUbicacion());
                    offerInternshipToUpdate.setSalario(offerInternship.getSalario());
                    offerInternshipToUpdate.setBusiness(offerInternship.getBusiness());
                    offerInternshipToUpdate.setPostulantes(offerInternship.getPostulantes());
                    return offerInternshipRepository.save(offerInternshipToUpdate);
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, offerInternshipId));
    }

    @Override
    public ResponseEntity<?> delete(Long offerInternshipId) {
        return offerInternshipRepository.findById(offerInternshipId)
                .map(offerInternship -> {
                    offerInternshipRepository.delete(offerInternship);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, offerInternshipId));
    }

    @Override
    public List<StudentResource> getPostulantesByOfferId(Long offerId) {
        OfferInternship offer = offerInternshipRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("OfferInternship", offerId));

        List<StudentResource> postulantes = offer.getPostulantes().stream()
                .map(offerIntershipStudent -> mapStudentToResource(offerIntershipStudent.getStudent()))
                .collect(Collectors.toList());

        return postulantes;
    }

    // Método para mapear Student a StudentResource
    private StudentResource mapStudentToResource(Student student) {
        // Lógica de mapeo, puedes usar un Mapper o hacerlo manualmente
        // ...

        // Ejemplo manual, ajusta según tus necesidades
        StudentResource studentResource = new StudentResource();
        studentResource.setId(student.getId());
        studentResource.setNombre(student.getNombre());
        // Mapea otros campos...

        return studentResource;
    }



}
