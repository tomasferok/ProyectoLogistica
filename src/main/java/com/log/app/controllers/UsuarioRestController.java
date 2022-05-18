package com.log.app.controllers;

import com.log.app.entidades.Usuario;
import com.log.app.services.TipoUsuarioService;
import com.log.app.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private TipoUsuarioService tipoUserService;

    @CrossOrigin

    @PostMapping("/register")
    public Usuario registrarse(String email, String password, String nombre, String apellido) {
        
        return userService.createUser(email, password, nombre, apellido);
    }

    @CrossOrigin
    @PostMapping("/login")
    public Usuario logearse(String email, String password) {
        Usuario usuario = userService.authenticateUsuario(email, password);
        return usuario;
    }
}
