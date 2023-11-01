package com.practifinder.webapp.practifinder.lifescape.api.knowledge.rest;

import com.practifinder.webapp.practifinder.lifescape.domain.knowledge.service.KnowledgeService;
import com.practifinder.webapp.practifinder.lifescape.mapping.knowledge.KnowledgeMapper;
import com.practifinder.webapp.practifinder.lifescape.resource.knowledge.CreateKnowledgeResource;
import com.practifinder.webapp.practifinder.lifescape.resource.knowledge.KnowledgeResource;
import com.practifinder.webapp.practifinder.lifescape.resource.knowledge.UpdateKnowledgeResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/languages")
public class KnowledgeController {
    private final KnowledgeService knowledgeService;

    private final KnowledgeMapper knowledgeMapper;

    public KnowledgeController(KnowledgeService knowledgeService, KnowledgeMapper knowledgeMapper){
        this.knowledgeMapper = knowledgeMapper;
        this.knowledgeService = knowledgeService;
    }

    @GetMapping
    public Page<KnowledgeResource> getAllKnowledge(Pageable pageable){
        return knowledgeMapper.modelListPage(knowledgeService.getAll(), pageable);
    }

    @GetMapping("{knowledgeId}")
    public KnowledgeResource getKnowledgeById(@PathVariable Long knowledgeId){
        return knowledgeMapper.toResource(knowledgeService.getById(knowledgeId));
    }

    @PostMapping
    public ResponseEntity<KnowledgeResource> createKnowledge(@RequestBody CreateKnowledgeResource resource){
        return new ResponseEntity<>(knowledgeMapper.toResource(knowledgeService.create(knowledgeMapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{knowledgeId}")
    public KnowledgeResource updateKnowledge(@PathVariable Long knowledgeId, @RequestBody UpdateKnowledgeResource resource){
        return knowledgeMapper.toResource(knowledgeService.update(knowledgeId,knowledgeMapper.toModel(resource)));
    }

    @DeleteMapping("{knowledgeId}")
    public ResponseEntity<?> deleteKnowledge(@PathVariable Long knowledgeId){
        return knowledgeService.delete(knowledgeId);
    }
}
