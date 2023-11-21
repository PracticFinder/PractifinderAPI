package com.practifinder.webapp.security.domain.service;

import com.practifinder.webapp.security.domain.model.entity.User;
import com.practifinder.webapp.security.domain.service.communication.AuthenticateRequest;
import com.practifinder.webapp.security.domain.service.communication.RegisterRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public void register(RegisterRequest registerRequest);

    public List<RegisterRequest> list();

    public void delete(Long userId);

    public void modify(Long id, RegisterRequest registerRequest);


    public RegisterRequest getUserById(Long userId);

    public RegisterRequest getUserByUsername(String username);

    public RegisterRequest getUserByRoleId(Long roleId);
}
