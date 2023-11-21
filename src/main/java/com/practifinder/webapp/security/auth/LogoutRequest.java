package com.practifinder.webapp.security.auth;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class LogoutRequest {
    private String username;
}
