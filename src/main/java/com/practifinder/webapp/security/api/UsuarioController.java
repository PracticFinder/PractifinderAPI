package com.practifinder.webapp.security.api;

import com.practifinder.webapp.security.domain.model.entity.Role;
import com.practifinder.webapp.security.domain.service.RoleService;
import com.practifinder.webapp.security.domain.service.UserService;
import com.practifinder.webapp.security.domain.service.communication.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/auth/Usuario")
public class UsuarioController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService rolesService;


    @PostMapping("/RegistrarRol")
    public void registrarRol(@RequestBody Role roles){
        rolesService.insert(roles);
    }


    @GetMapping("/ListarRol")
    public ResponseEntity<List<Role>> listarRol(){
        return new ResponseEntity<>(rolesService.list(), HttpStatus.OK);
    }


    @GetMapping("/ListarRol/{id}")
    public ResponseEntity<Role> listarRolById(@PathVariable("id") Long id){
        return new ResponseEntity<>(rolesService.getRolesById(id), HttpStatus.OK);
    }


    @PostMapping("/Registrar")
    public void registrar(@RequestBody RegisterRequest registerRequest){
        userService.register(registerRequest);
    }


    @GetMapping("/Listar")
    public ResponseEntity<List<RegisterRequest>> listar(){
        return new ResponseEntity<>(userService.list(), HttpStatus.OK);
    }


    @GetMapping("/Listar/{id}")
    public ResponseEntity<RegisterRequest> listarById(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/ListarByUsername/{username}")
    public ResponseEntity<RegisterRequest> listarByUsername(@PathVariable("username") String username){
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/ListarByRoleId/{roleId}")
    public ResponseEntity<RegisterRequest> listarByRoleId(@PathVariable("roleId") Long roleId){
        return new ResponseEntity<>(userService.getUserByRoleId(roleId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id){userService.delete(id);}


    @PutMapping("/{id}")
    public void modificar(@PathVariable("id") Long id,@RequestBody RegisterRequest registerRequest){
        userService.modify(id,registerRequest);
    }

}

