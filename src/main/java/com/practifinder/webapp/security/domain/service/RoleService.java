package com.practifinder.webapp.security.domain.service;

import com.practifinder.webapp.security.domain.model.entity.Role;
import com.practifinder.webapp.security.domain.service.communication.RegisterRequest;

import java.util.List;

public interface RoleService {
    public void insert(Role roles);

    public List<Role> list();

    public void delete(Long rolId);

    public void modify(Long id, RegisterRequest registerRequest);

    public Role getRolesById(Long rolId);
}