package com.log.app.controllers;

import java.util.List;

import com.log.app.daos.IUsuarioDao;
import com.log.app.entidades.TipoUsuario;
import com.log.app.entidades.Usuario;
import com.log.app.services.TipoUsuarioService;
import com.log.app.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioController {
    @Autowired
    private UserService userService;
    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping(value = "/login")
    public String login() {

        return "login";
    }

    @PostMapping(value = "/login")
    public String logearse() {
        return "login";
    }

    @GetMapping(value = "/registro")
    public String registro() {
        userService.createUser(new Usuario(
                "nombre",
                "apellido",
                "admin",
                "admin",
                true,
                tipoUsuarioService.findById(1l)

        ));
        return "registro";
    }

    @PostMapping("/registro/")
    public String registrarse() {

        return "login";
    }

}
