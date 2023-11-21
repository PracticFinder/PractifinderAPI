package com.practifinder.webapp.security.resource;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class UserResource {
    private Long id;
    private String name;
    private String username;
    private String correo;
    private List<RoleResource> roles;
}

