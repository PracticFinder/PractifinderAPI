package com.practifinder.webapp.practifinder.lifescape.service.language;

import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.language.persistence.LanguageRepository;
import com.practifinder.webapp.practifinder.lifescape.domain.language.service.LanguageService;
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
public class LanguageServiceImpl implements LanguageService {
    private static final String ENTITY = "Language";
    private final LanguageRepository languageRepository;
    private final Validator validator;

    public LanguageServiceImpl(LanguageRepository languageRepository, Validator validator){
        this.languageRepository = languageRepository;
        this.validator = validator;
    }

    @Override
    public List<Language> getAll(){
        return languageRepository.findAll();
    }

    @Override
    public Page<Language> getAll(Pageable pageable) {
        return languageRepository.findAll(pageable);
    }

    @Override
    public Language getById(Long languageId) {
        return languageRepository.findById(languageId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, languageId));
    }

    @Override
    public Language create(Language language){
        Set<ConstraintViolation<Language>> violations = validator.validate(language);

        if(!violations.isEmpty()){
         throw new ResourceValidationException(ENTITY, violations);
        }
        return languageRepository.save(language);
    }

    @Override
    public Language update(Long id, Language language) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long languageId) {
        return languageRepository.findById(languageId).map(language ->{
                    languageRepository.delete(language);
                    return ResponseEntity.ok().build();})
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,languageId));
    }


}
