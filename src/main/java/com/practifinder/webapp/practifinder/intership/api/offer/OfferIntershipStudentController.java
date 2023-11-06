package com.practifinder.webapp.practifinder.intership.api.offer;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntership;
import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferIntershipStudent;
import com.practifinder.webapp.practifinder.intership.domain.offer.persistence.OfferIntershipRepository;
import com.practifinder.webapp.practifinder.intership.domain.offer.persistence.OfferIntershipStudentRepository;
import com.practifinder.webapp.practifinder.intership.domain.offer.service.OfferIntershipStudentService;
import com.practifinder.webapp.practifinder.intership.mapping.offer.OfferIntershipStudentMapper;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferIntershipStudentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/offerintershipstudent")
public class OfferIntershipStudentController {
    private final OfferIntershipStudentService offerIntershipStudentService;

    private final OfferIntershipRepository offerIntershipRepository;
    private final OfferIntershipStudentMapper mapper;

    private final OfferIntershipStudentRepository offerIntershipStudentRepository;

    public OfferIntershipStudentController(OfferIntershipStudentService offerIntershipStudentService, OfferIntershipRepository offerIntershipRepository, OfferIntershipStudentMapper mapper, OfferIntershipStudentRepository offerIntershipStudentRepository) {
        this.offerIntershipStudentService = offerIntershipStudentService;
        this.offerIntershipRepository = offerIntershipRepository;
        this.mapper = mapper;
        this.offerIntershipStudentRepository = offerIntershipStudentRepository;
    }

    @GetMapping
    public Page<OfferIntershipStudentResource> getAllOfferIntershipStudent(Pageable pageable){
        return mapper.modelListPage(offerIntershipStudentService.getAll(),pageable);
    }

    @GetMapping("student/{studentId}")
    public Page<OfferIntershipStudentResource> getAllOfferIntershipStudentByStudentId(@PathVariable Long studentId, Pageable pageable){
        return mapper.modelListPage(offerIntershipStudentService.getAllByStudentId(studentId),pageable);
    }

    @GetMapping("{intershipId}")
    public Page<OfferIntershipStudentResource> getAllOfferIntershipStudentByIntershipId(@PathVariable Long intershipId, Pageable pageable){
        return mapper.modelListPage(offerIntershipStudentService.getAllStudentsByOfferIntershipId(intershipId),pageable);
    }

    @GetMapping("{intershipId}/students/{studentId}")
    public Page<OfferIntershipStudentResource> getAllOfferIntershipStudentByIntershipIdAndStudentId(@PathVariable Long intershipId,@PathVariable Long studentId, Pageable pageable){
        return mapper.modelListPage(offerIntershipStudentService.getAllStudentsByOfferIntershipId(intershipId),pageable);
    }

    @PostMapping("/{intershipId}/estudents")
    public ResponseEntity<List<OfferIntershipStudent>> addExperienceToStudent(@PathVariable Long intershipId) {
        List<OfferIntershipStudent> experiences = offerIntershipStudentService.getAllStudentsByOfferIntershipId(intershipId);
        return ResponseEntity.ok(experiences);
    }


}
