package com.practifinder.webapp.security.auth;

import com.practifinder.webapp.security.domain.persistence.UserRepository;
import com.practifinder.webapp.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse logout(String username) {
        UserDetails user = userRepository.findByUsername(username).orElseThrow();
        String logoutToken = jwtService.getLogoutToken(user);
        // Realiza acciones adicionales de logout si es necesario (eliminar cookies, etc.)
        SecurityContextHolder.clearContext();  // Limpiar el contexto de seguridad
        return AuthResponse.builder()
                .token(logoutToken)
                .build();
    }




}