package com.practifinder.webapp.practifinder.lifescape.domain.language.service;

import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LanguageService {
    List<Language> getAll();

    Page<Language> getAll(Pageable pageable);

    Language getById(Long languageId);

    Language create(Language language);
    Language update(Long id, Language language);
    ResponseEntity<?> delete(Long languageId);

    List<Language> getByStudentId(Long studentId);
}