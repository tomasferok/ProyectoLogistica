package com.log.app.controllers;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import com.log.app.entidades.Usuario;
import com.log.app.exepciones.EmailYaExisteExeption;
import com.log.app.exepciones.LoginRequestIncorrectaExeption;
import com.log.app.helpers.LoginRequest;
import com.log.app.services.TipoUsuarioService;
import com.log.app.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Usuario registrarse(String email, String password, String nombre, String apellido)
            throws EmailYaExisteExeption {
        Usuario usuario;

        usuario = userService.createUser(email, password, nombre, apellido);

        return usuario;
    }

    @CrossOrigin
    @PostMapping("/login")
    public Usuario logearse(@RequestBody LoginRequest loginRequest) throws LoginRequestIncorrectaExeption {
        System.out.println(loginRequest.email);
        System.out.println(loginRequest.password);
        Usuario usuario;
        usuario = userService.authenticateUsuario(loginRequest.email, loginRequest.password);

        return usuario;

    }

    

    @CrossOrigin
    @PostMapping("/loginMovil")
    public Usuario logearseMovil(LoginRequest loginRequest) throws LoginRequestIncorrectaExeption {
        System.out.println(loginRequest.email);
        System.out.println(loginRequest.password);
        Usuario usuario;

        usuario = userService.authenticateUsuario(loginRequest.email, loginRequest.password);

        return usuario;

    }
    
    @ExceptionHandler({ LoginRequestIncorrectaExeption.class })
    public ResponseEntity<Object> loginExeptionHandler(LoginRequestIncorrectaExeption exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({ EmailYaExisteExeption.class })
    public ResponseEntity<Object> registrationExeptionHandler(EmailYaExisteExeption exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
