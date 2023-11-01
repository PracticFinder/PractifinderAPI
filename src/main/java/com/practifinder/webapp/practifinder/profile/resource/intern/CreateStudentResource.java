package com.practifinder.webapp.practifinder.profile.resource.intern;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentResource {

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
    private int edad;

    @URL
    private String profile_img;

}
