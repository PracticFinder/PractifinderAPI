package com.practifinder.webapp.practifinder.intership.resource.offer;

import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithoutOfferResource {
    private Long id;
    private Student student;
}
