package com.practifinder.webapp.security.domain.persistence;

import com.practifinder.webapp.security.domain.model.entity.Role;
import com.practifinder.webapp.security.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);
    Optional<User> findByRole(Role role);

    Boolean existsByUsername(String username);
    Boolean existsByCorreo(String email);
}