package com.practifinder.webapp.practifinder.profile.resource.intern;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
public class UpdateStudentResource {


    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String email;

    @Min(value = 18)
    @Max(value = 80)
    private int age;

    @URL
    private String profile_img;

}
