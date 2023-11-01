package com.practifinder.webapp.practifinder.lifescape.api.language.rest;

import com.practifinder.webapp.practifinder.lifescape.domain.language.service.LanguageService;
import com.practifinder.webapp.practifinder.lifescape.mapping.language.LanguageMapper;
import com.practifinder.webapp.practifinder.lifescape.resource.language.CreateLanguageResource;
import com.practifinder.webapp.practifinder.lifescape.resource.language.LanguageResource;
import com.practifinder.webapp.practifinder.lifescape.resource.language.UpdateLanguageResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/languages")
public class LanguageController {
    private final LanguageService languageService;
    private final LanguageMapper mapper;

    public LanguageController(LanguageService languageService, LanguageMapper mapper){
        this.languageService = languageService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<LanguageResource> getAllLanguages(Pageable pageable){
        return mapper.modelListPage(languageService.getAll(), pageable);
    }

    @GetMapping("{languageId}")
    public LanguageResource getLanguageById(@PathVariable Long languageId){
        return mapper.toResource(languageService.getById(languageId));
    }

    @PostMapping
    public ResponseEntity<LanguageResource> createLanguage(@RequestBody CreateLanguageResource resource){
        return new ResponseEntity<>(mapper.toResource(languageService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{languageId}")
    public LanguageResource updateLanguage(@PathVariable Long languageId,
                                           @RequestBody UpdateLanguageResource resource){
        return mapper.toResource(languageService.update(languageId,mapper.toModel(resource)));
    }

    @DeleteMapping("{languageId}")
    public ResponseEntity<?> deleteLanguage(@PathVariable Long paymentId){
        return languageService.delete(paymentId);
    }
}
