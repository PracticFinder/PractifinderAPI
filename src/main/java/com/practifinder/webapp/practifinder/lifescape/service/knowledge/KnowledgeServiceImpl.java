package com.practifinder.webapp.practifinder.lifescape.service.knowledge;

import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.model.Knowledge;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.persistence.KnowledgeRepository;
import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.service.KnowledgeService;
import com.practifinder.webapp.practifinder.profile.domain.intern.service.StudentService;
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

@Service
public class KnowledgeServiceImpl implements KnowledgeService {
    private static final String ENTITY = "Knowledge";
    private final KnowledgeRepository knowledgeRepository;

    private final StudentService studentService;
    private final Validator validator;

    public KnowledgeServiceImpl(KnowledgeRepository knowledgeRepository, Validator validator,
                                StudentService studentService){
        this.knowledgeRepository = knowledgeRepository;
        this.validator = validator;
        this.studentService = studentService;
    }

    @Override
    public List<Knowledge> getAll(){
        return knowledgeRepository.findAll();
    }

    @Override
    public Page<Knowledge> getAll(Pageable pageable) {
        return knowledgeRepository.findAll(pageable);
    }

    @Override
    public Knowledge getById(Long knowledgeId) {
        return knowledgeRepository.findById(knowledgeId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, knowledgeId));
    }

    @Override
    public Knowledge create(Knowledge knowledge){
        Set<ConstraintViolation<Knowledge>> violations = validator.validate(knowledge);

        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY, violations);
        }

        return knowledgeRepository.save(knowledge);
    }

    @Override
    public Knowledge update(Long id, Knowledge knowledge) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long knowledgeId) {
        return knowledgeRepository.findById(knowledgeId).map(knowledge ->{
                    knowledgeRepository.delete(knowledge);
                    return ResponseEntity.ok().build();})
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,knowledgeId));
    }

    @Override
    public List<Knowledge> getByStudentId(Long studentId) {
        return knowledgeRepository.findByStudentId(studentId);
    }
}
