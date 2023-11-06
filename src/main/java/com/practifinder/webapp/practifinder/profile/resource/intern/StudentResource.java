package com.practifinder.webapp.practifinder.profile.resource.intern;

import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.StudentKnowledge;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.StudentLanguage;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.StudentSkill;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class StudentResource {
    private Long id;
    private String name;
    private String  email;
    private int age;
    private String profile_img;
    private Set<StudentKnowledge> studentKnowledgeList;
    private Set<Experience> experienceList;
    private Set<StudentSkill> studentSkillList;
    private Set<StudentLanguage> studentLanguageList;
}