package com.practifinder.webapp.security.service;

import com.practifinder.webapp.security.domain.model.entity.Role;
import com.practifinder.webapp.security.domain.model.enumeration.Roles;
import com.practifinder.webapp.security.domain.persistence.RoleRepository;
import com.practifinder.webapp.security.domain.service.RoleService;
import com.practifinder.webapp.security.domain.service.communication.RegisterRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public void insert(Role roles) {
        roleRepository.save(roles);
    }

    @Override
    public List<Role> list() {
        return roleRepository.findAll();
    }

    @Override
    public void delete(Long rolId) {
        roleRepository.deleteById(rolId);
    }

    @Override
    public void modify(Long id, RegisterRequest registerRequest) {
        Role roles = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el rol con ID " + id));
        roles.setName(roles.getName());
        roleRepository.save(roles);
    }

    @Override
    public Role getRolesById(Long rolId) {
        return roleRepository.findById(rolId).orElseThrow(() -> new EntityNotFoundException("No se encontró el rol con ID " + rolId));
    }
}
