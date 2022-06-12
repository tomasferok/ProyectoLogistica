package com.log.app.services.Impl;

import com.log.app.daos.IUsuarioDao;
import com.log.app.entidades.TipoUsuario;
import com.log.app.entidades.Usuario;
import com.log.app.exepciones.EmailYaExisteExeption;
import com.log.app.exepciones.LoginRequestIncorrectaExeption;
import com.log.app.helpers.AuthenticationResponse;
import com.log.app.security.JwtUtil;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Usuario findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

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

    public Usuario createUser(Usuario user) {
        return userRepository.save(user);
    }

    public AuthenticationResponse authenticateUsuario(String email, String password)
            throws LoginRequestIncorrectaExeption {

        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        email,
                        password));

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

    public Usuario findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Usuario usuario = userRepository.findByEmail(username);

        UserDetails user = User.withUsername(usuario.getEmail()).password(usuario.getPassword()).authorities(
                usuario.getTipoUsuario().getTipoUsuario())
                .build();

        return user;
    }

    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

}
