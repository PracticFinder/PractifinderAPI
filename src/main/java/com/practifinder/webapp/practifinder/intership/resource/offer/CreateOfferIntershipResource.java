package com.practifinder.webapp.practifinder.intership.resource.offer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateOfferIntershipResource {

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String title;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String description;

    @NotNull
    @NotBlank
    private Date dateInit;

    @NotNull
    @NotBlank
    private Date dateEnd;

    @NotNull
    @NotBlank
    @Size(max = 80)
    private String location;


}
