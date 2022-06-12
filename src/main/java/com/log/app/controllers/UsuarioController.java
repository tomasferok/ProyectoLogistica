package com.log.app.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.log.app.daos.IUsuarioDao;
import com.log.app.entidades.TipoUsuario;
import com.log.app.entidades.Usuario;
import com.log.app.services.Impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioController {
    @Autowired
    private UserService userService;
    // @Autowired
    // private TipoUsuarioService tipoUsuarioService;

    @GetMapping(value = "/")
    public String login(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping(value = "/login")
    public String logearse(@ModelAttribute Usuario usuario, Model model) {

        try {
            userService.authenticateUsuario(usuario.getEmail(), usuario.getPassword());
            return "homepage";

        } catch (Exception e) {
            model.addAttribute("exeption", e.getMessage());
            return "login";
        }

    }

    @GetMapping(value = "/registro")
    public String registro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarse(@ModelAttribute Usuario usuario) {

        usuario.setTipoUsuario(TipoUsuario.ADMIN);
        usuario.setActive(true);
        userService.createUser(usuario);
        return "login";
    }

}
