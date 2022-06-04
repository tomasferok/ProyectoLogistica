package com.log.app.controllers;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import com.log.app.entidades.Usuario;
import com.log.app.exepciones.EmailYaExisteExeption;
import com.log.app.exepciones.LoginRequestIncorrectaExeption;
import com.log.app.helpers.AuthenticationRequest;
import com.log.app.helpers.AuthenticationResponse;
import com.log.app.security.JwtUtil;
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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
    @Autowired
    private UserService userService;
    // @Autowired
    // private TipoUsuarioService tipoUserService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired

    private JwtUtil jwtUtil;

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
    public Usuario logearse(@RequestBody AuthenticationRequest loginRequest) throws LoginRequestIncorrectaExeption {

        Usuario usuario;
        usuario = userService.authenticateUsuario(loginRequest.getEmail(), loginRequest.getPassword());

        return usuario;

    }

    @CrossOrigin
    @PostMapping("/loginMovil")
    public ResponseEntity<AuthenticationResponse> logearseMovil(
            @RequestBody AuthenticationRequest loginRequest) throws LoginRequestIncorrectaExeption,
            BadCredentialsException {
        System.out.println(loginRequest);

        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                        loginRequest.getPassword()));

        UserDetails userDetals = userService.loadUserByUsername(loginRequest.getEmail());
        Usuario usuario = userService.findByEmail(loginRequest.getEmail());
        String jwt = jwtUtil.generateToken(userDetals);
        return new ResponseEntity<>(new AuthenticationResponse(jwt, usuario.getEmail(), usuario.getIdUsuario()),
                HttpStatus.OK);

    }

    @ExceptionHandler({ LoginRequestIncorrectaExeption.class })
    public ResponseEntity<Object> loginExeptionHandler(LoginRequestIncorrectaExeption exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler({ BadCredentialsException.class })
    public ResponseEntity<Object> badCredentialsExceptonHandler(BadCredentialsException exception) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({ EmailYaExisteExeption.class })
    public ResponseEntity<Object> registrationExeptionHandler(EmailYaExisteExeption exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
