package com.practifinder.webapp.security.service;

import com.practifinder.webapp.practifinder.profile.domain.business.model.Business;
import com.practifinder.webapp.practifinder.profile.domain.business.persistence.BusinessRepository;
import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import com.practifinder.webapp.practifinder.profile.domain.intern.persistence.StudentRepository;
import com.practifinder.webapp.security.domain.model.entity.Role;
import com.practifinder.webapp.security.domain.model.entity.User;
import com.practifinder.webapp.security.domain.persistence.RoleRepository;
import com.practifinder.webapp.security.domain.persistence.UserRepository;
import com.practifinder.webapp.security.domain.service.UserService;
import com.practifinder.webapp.security.domain.service.communication.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void register(RegisterRequest request) {
        Role role = roleRepository.findById(request.getRolId())
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));


        User user = new User();
        user.setName(request.getName());
        user.setRole(role);
        user.setUsername(request.getUsername());
        user.setCorreo(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
    }

    @Override
    public List<RegisterRequest> list() {
        List<User> users = userRepository.findAll();
        List<RegisterRequest> soloDTO = new ArrayList<>();
        RegisterRequest elem;

        for (User user : users) {
            elem = new RegisterRequest();
            elem.setName(user.getName());
            elem.setRolId(user.getRole().getId());
            elem.setUsername(user.getUsername());
            elem.setEmail(user.getCorreo());
            elem.setPassword(user.getPassword());
            soloDTO.add(elem);
        }

        return soloDTO;
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void modify(Long id, RegisterRequest registerRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: User is not found."));

        Role role = roleRepository.findById(registerRequest.getRolId())
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));

        user.setName(registerRequest.getName());
        user.setRole(role);
        user.setUsername(registerRequest.getUsername());
        user.setCorreo(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return user;
    }

    @Override
    public RegisterRequest getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Error: User is not found."));
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setName(user.getName());
        registerRequest.setRolId(user.getRole().getId());
        registerRequest.setUsername(user.getUsername());
        registerRequest.setEmail(user.getCorreo());
        registerRequest.setPassword(user.getPassword());
        return registerRequest;
    }

    @Override
    public RegisterRequest getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Error: User is not found."));
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setName(user.getName());
        registerRequest.setRolId(user.getRole().getId());
        registerRequest.setUsername(user.getUsername());
        registerRequest.setEmail(user.getCorreo());
        registerRequest.setPassword(user.getPassword());
        return registerRequest;
    }

    @Override
    public RegisterRequest getUserByRoleId(Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Error: Role not found."));

        User user = userRepository.findByRole(role)
                .orElseThrow(() -> new RuntimeException("Error: User is not found."));

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setName(user.getName());
        registerRequest.setRolId(user.getRole().getId());
        registerRequest.setUsername(user.getUsername());
        registerRequest.setEmail(user.getCorreo());
        registerRequest.setPassword(user.getPassword());

        return registerRequest;
    }

    @Override
    public void registerStudent(RegisterRequest user) {

        Student student = new Student();

        student.setNombre(user.getName());

        student.setRolId(user.getRolId());

        student.setUsername(user.getUsername());

        student.setCorreo(user.getEmail());

        student.setPassword(passwordEncoder.encode(user.getPassword()));

        studentRepository.save(student);

    }

    @Override
    public void registerBusiness(RegisterRequest user) {

        Business business = new Business();

        business.setNombre(user.getName());

        business.setRolId(user.getRolId());

        business.setUsername(user.getUsername());

        business.setCorreo(user.getEmail());

        business.setPassword(passwordEncoder.encode(user.getPassword()));

        businessRepository.save(business);

    }

}
