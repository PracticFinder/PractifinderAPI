package com.practifinder.webapp.practifinder.profile.resource.intern;


import lombok.*;

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
}
