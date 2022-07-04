package com.log.app.controllers;


import javax.validation.ValidationException;
import com.log.app.entidades.Usuario;
import com.log.app.exepciones.EmailYaExisteExeption;
import com.log.app.exepciones.LoginRequestIncorrectaExeption;
import com.log.app.helpers.AuthenticationRequest;
import com.log.app.helpers.AuthenticationResponse;
import com.log.app.security.JwtUtil;
import com.log.app.services.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador Rest para la clase Usuario
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "*" })
public class UsuarioRestController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * @param email
     * @param password
     * @param nombre
     * @param apellido
     * @return Usuario
     * @throws EmailYaExisteExeption
     * @describe Crea un usuario nuevo en la base de datos, el password se encripta
     *           con bcrypt
     */
    @PostMapping("/register")
    public Usuario registrarse(String email, String password, String nombre, String apellido)
            throws EmailYaExisteExeption {
        System.out.println("Password " + password);
        Usuario usuario = userService.createUser(email, password, nombre, apellido);

        return usuario;
    }

    /**
     * @param id
     * @return Usuario
     */
    @PostMapping("/usuario/")
    public Usuario getUserById(@RequestParam(name = "id") Long id) {

        Usuario usuario = userService.findById(id);

        return usuario;
    }

    /**
     * @param logearse(
     * @return ResponseEntity<AuthenticationResponse>
     */
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> logearse(
            @RequestBody AuthenticationRequest loginRequest) throws LoginRequestIncorrectaExeption,
            BadCredentialsException {
        System.out.println("loginRequest: " + loginRequest.getEmail() + " " + loginRequest.getPassword());
        AuthenticationResponse response = userService.authenticateUsuario(loginRequest.getEmail(),
                loginRequest.getPassword());

        return new ResponseEntity<>(response,
                HttpStatus.OK);

    }

    /**
     * @param 
     * @return List<Usuario>
     * @describe Obtiene todos los usuarios de la base de datos
     */

    @GetMapping("/usuario/")
    public List<Usuario> getAllUsers() {
        return userService.findAll();
    }

    /**
     * @param id
     * @return void
     * @describe Elimina un usuario de la base de datos
     */
    @DeleteMapping("/usuario/")
    public void deleteUser(@RequestParam(name = "id") Long id) {
        userService.deleteUser(id);
    }


    /**
     * @param exception
     * @return ResponseEntity<Object>
     * @describe Maneja las excepciones de la clase UsuarioService
     */
     */
    
    /** 
     * @param exception
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({ LoginRequestIncorrectaExeption.class })
    public ResponseEntity<Object> loginExeptionHandler(LoginRequestIncorrectaExeption exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    /**
     * @param exception
     * @return ResponseEntity<Object>
     * @describe Maneja las excepciones de la clase UsuarioService
     */
     */
    
    /** 
     * @param exception
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({ BadCredentialsException.class })
    public ResponseEntity<Object> badCredentialsExceptonHandler(BadCredentialsException exception) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * @param exception
     * @return ResponseEntity<Object>
     * @describe Maneja las excepciones de la clase UsuarioService
     */
    
    /** 
     * @param exception
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({ EmailYaExisteExeption.class })
    public ResponseEntity<Object> registrationExeptionHandler(EmailYaExisteExeption exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
