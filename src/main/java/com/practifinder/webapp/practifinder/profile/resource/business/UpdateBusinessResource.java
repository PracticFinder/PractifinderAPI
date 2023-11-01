package com.practifinder.webapp.practifinder.profile.resource.business;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBusinessResource {
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(unique = true)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String location;

}
