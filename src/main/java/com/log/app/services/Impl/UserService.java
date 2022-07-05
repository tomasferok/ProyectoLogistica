package com.log.app.services.Impl;

import com.log.app.daos.IUsuarioDao;
import com.log.app.entidades.TipoUsuario;
import com.log.app.entidades.Usuario;
import com.log.app.exepciones.EmailYaExisteExeption;
import com.log.app.exepciones.LoginRequestIncorrectaExeption;
import com.log.app.helpers.AuthenticationResponse;
import com.log.app.security.JwtUtil;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Servicio de la entidad Usuario
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Service
@Transactional
public class UserService implements UserDetailsService {
    @Autowired
    private IUsuarioDao userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public UserService(IUsuarioDao userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param id
     * @return Usuario
     */
    public Usuario findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * @param email
     * @param password
     * @param nombre
     * @param apellido
     * @return Usuario
     * @throws EmailYaExisteExeption
     */
    public Usuario createUser(String email, String password, String nombre, String apellido)
            throws EmailYaExisteExeption {
        if (userRepository.findByEmail(email) != null) {
            throw new EmailYaExisteExeption("El email ya existe");
        }

        Usuario user = new Usuario();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setActive(true);
        // TODO: setear el tipo de usuario
        user.setTipoUsuario(TipoUsuario.ADMIN);
        // TODO: encriptar password
        return userRepository.save(user);

    }

    /**
     * @param user
     * @return Usuario
     */
    public Usuario createUser(Usuario user) {
        return userRepository.save(user);
    }

    /**
     * @param email
     * @param password
     * @return AuthenticationResponse
     * @throws LoginRequestIncorrectaExeption
     */
    public AuthenticationResponse authenticateUsuario(String email, String password)
            throws LoginRequestIncorrectaExeption {

        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(email, password));

        UserDetails userDetals = loadUserByUsername(email);
        Usuario usuario = findByEmail(email);
        String jwt = jwtUtil.generateToken(userDetals);
        System.out.println(usuario);
        if (usuario == null) {
            throw new LoginRequestIncorrectaExeption("Email o contraseña incorrecta");
        }
        System.out.println(usuario);

        return new AuthenticationResponse(jwt, usuario.getEmail(), usuario.getIdUsuario());
    }

    /**
     * @param email
     * @return Usuario
     */
    public Usuario findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<Usuario> findAll() {
        return userRepository.findAll();
    }


    /**
     * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Usuario usuario = userRepository.findByEmail(username);

        UserDetails user = User.withUsername(usuario.getEmail()).password(usuario.getPassword()).authorities(
                usuario.getTipoUsuario().getTipoUsuario())
                .build();

        return user;
    }
    
    public void deleteUser(Usuario user) {
         userRepository.delete(user);
    }



    /**
     * @param email
     */
    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

}
