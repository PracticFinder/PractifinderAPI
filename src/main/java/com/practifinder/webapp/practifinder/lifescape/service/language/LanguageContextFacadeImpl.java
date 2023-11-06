package com.practifinder.webapp.practifinder.lifescape.service.language;

import com.practifinder.webapp.practifinder.lifescape.api.language.LanguageContextFacade;
import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.domain.language.service.LanguageService;

import java.util.List;

public class LanguageContextFacadeImpl implements LanguageContextFacade {

    private final LanguageService languageService;
    public LanguageContextFacadeImpl(LanguageService languageService){
        this.languageService =languageService;
    }

    @Override
    public List<Language> getAllLanguages() {
        return languageService.getAll();}
}
