package com.practifinder.webapp.practifinder.intership.service.offer;


import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternship;
import com.practifinder.webapp.practifinder.intership.domain.offer.model.OfferInternshipStudent;
import com.practifinder.webapp.practifinder.intership.domain.offer.persistence.OfferInternshipRepository;
import com.practifinder.webapp.practifinder.intership.domain.offer.persistence.OfferInternshipStudentRepository;
import com.practifinder.webapp.practifinder.intership.domain.offer.service.OfferInternshipService;
import com.practifinder.webapp.practifinder.intership.domain.offer.service.OfferInternshipStudentService;
import com.practifinder.webapp.practifinder.intership.mapping.offer.OfferIntershipStudentMapper;
import com.practifinder.webapp.practifinder.intership.mapping.offer.OfferIntershipStudentsMapper;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferInternshipResource;
import com.practifinder.webapp.practifinder.intership.resource.offer.OfferInternshipStudentsResource;
import com.practifinder.webapp.practifinder.intership.resource.offer.UpdateOfferInternshipResource;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import com.practifinder.webapp.practifinder.profile.domain.intern.persistence.StudentRepository;
import com.practifinder.webapp.practifinder.profile.domain.intern.service.StudentService;
import com.practifinder.webapp.practifinder.profile.mapping.intern.StudentMapper;
import com.practifinder.webapp.practifinder.profile.resource.intern.StudentResource;
import com.practifinder.webapp.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OfferInternshipStudentServiceImpl implements OfferInternshipStudentService {

    @Autowired
    private OfferInternshipStudentRepository offerInternshipStudentRepository;

    @Autowired
    private OfferInternshipRepository offerInternshipRepository;

    @Autowired
    private OfferInternshipService offerIntershipService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private OfferIntershipStudentsMapper offerInternshipMapper;

    @Autowired
    private OfferIntershipStudentMapper offerIntershipStudentMapper;

    public List<Student> getPostulantes(Long offerId) {
        OfferInternship offer = offerInternshipRepository.findByIdWithPostulantes(offerId);
        if (offer == null) {
            throw new ResourceNotFoundException("OfferInternship", offerId);
        }
        List<Student> students = offerInternshipStudentRepository.findStudentsByOfferId(offerId);
        return students;
    }

    public List<OfferInternship> getPostulaciones(Long studentId) {
        Student student = studentRepository.findByIdWithPostulaciones(studentId);
        if (student == null) {
            throw new ResourceNotFoundException("Student", studentId);
        }
        List<OfferInternship> offers = offerInternshipStudentRepository.findOffersByStudentId(studentId);
        return offers;
    }

    public StudentResource getStudent(Long offerId, Long studentId) {
        OfferInternship offer = offerInternshipRepository.findByIdWithPostulantes(offerId);
        if (offer == null) {
            throw new ResourceNotFoundException("OfferInternship", offerId);
        }

        Student student = studentRepository.findByIdWithPostulaciones(studentId);
        if (student == null) {
            throw new ResourceNotFoundException("Student", studentId);
        }

        StudentResource studentResource = studentMapper.toResource(student);

        return studentResource;
    }


    public OfferInternship getOffer(Long offerId, Long studentId) {
        OfferInternship offer = offerInternshipRepository.findByIdWithPostulantes(offerId);
        if (offer == null) {
            throw new ResourceNotFoundException("OfferInternship", offerId);
        }
        Student student = studentRepository.findByIdWithPostulaciones(studentId);
        if (student == null) {
            throw new ResourceNotFoundException("Student", studentId);
        }
        return offer;
    }

    public void registerStudentForOffer(Long offerId, Long studentId) {
        OfferInternship offer = offerIntershipService.getById(offerId);
        Student student = studentService.getById(studentId);

        OfferInternshipStudentsResource offerRegistration = offerInternshipMapper.toResource(offer);
        StudentResource studentRegistration = studentMapper.toResource(student);

        OfferInternshipResource offerInternship = offerIntershipStudentMapper.toResource(offer);


        OfferInternshipStudent offerInternshipStudent = new OfferInternshipStudent();
        offerInternshipStudent.setOffer(offer);
        offerInternshipStudent.setStudent(student);

        offer.getPostulantes().add(offerInternshipStudent);
        student.getPostulaciones().add(offerInternshipStudent);

        offerRegistration.getPostulantes().add(studentRegistration);
        studentRegistration.getPostulaciones().add(offerInternship);


        studentService.update(studentId, student);
        offerIntershipService.update(offerId, offer);

        offerInternshipStudentRepository.save(offerInternshipStudent);
    }

    @Override
    public List<Student> getPostulantes(List<OfferInternshipStudent> lista) {
        List<Student> students = lista.stream()
                .map(OfferInternshipStudent::getStudent)
                .collect(Collectors.toList());

        return students;
    }

    @Override
    public List<OfferInternship> getPostulaciones(List<OfferInternshipStudent> lista) {
        List<OfferInternship> offers = lista.stream()
                .map(OfferInternshipStudent::getOffer)
                .collect(Collectors.toList());
        return offers;
    }

}

