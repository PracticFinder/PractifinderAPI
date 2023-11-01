package com.practifinder.webapp.practifinder.lifescape.mapping.language;

import com.practifinder.webapp.practifinder.lifescape.domain.language.model.Language;
import com.practifinder.webapp.practifinder.lifescape.resource.language.CreateLanguageResource;
import com.practifinder.webapp.practifinder.lifescape.resource.language.LanguageResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class LanguageMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;
    public LanguageResource toResource(Language model){
        return mapper.map(model, LanguageResource.class);
    }
    public Language toModel(CreateLanguageResource resource){
        return mapper.map(resource, Language.class);
    }
    public Page<LanguageResource> modelListPage (List<Language> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, LanguageResource.class), pageable, modelList.size());
    }

}
