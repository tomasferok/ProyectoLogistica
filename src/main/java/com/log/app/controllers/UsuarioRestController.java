package com.log.app.controllers;

import com.log.app.entidades.Usuario;
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

    @PostMapping("/register")
    public Usuario registrarse(@RequestBody Usuario usuario) {
        return userService.createUser(usuario);
    }

    @CrossOrigin
    @PostMapping("/login")
    public Usuario logearse(String email, String password) {
        return userService.authenticateUsuario(email, password);
    }
}
