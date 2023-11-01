package com.practifinder.webapp.practifinder.profile.resource.student;


import com.practifinder.webapp.practifinder.experience.domain.model.Experience;
import lombok.*;

import java.util.List;
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
    private String profileImg;
    private List<Experience> experiences;
}
