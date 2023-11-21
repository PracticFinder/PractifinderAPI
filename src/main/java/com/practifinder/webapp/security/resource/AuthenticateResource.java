package com.practifinder.webapp.security.resource;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class AuthenticateResource {
    private Long id;
    private String name;
    private String username;
    private String correo;
    private Long role;
    private String token;
}
