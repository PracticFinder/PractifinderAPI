package com.practifinder.webapp.practifinder.profile.resource.business;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateBusinessResource {

    @NotNull
    @Size(max = 100)
    private String nombre;

    @NotNull
    @Size(max = 50)
    private String username;

    @NotNull
    @Size(max = 50)
    private String password;

    @NotNull
    private Long rolId;


    @Size(max = 200)
    private String location;


    @URL
    private String imagen;


    @Size(max = 200)
    private String siteWeb;

}
