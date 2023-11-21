package com.practifinder.webapp.practifinder.lifescape.domain.language.persistence;

import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository  extends JpaRepository<Language, Long> {
}
