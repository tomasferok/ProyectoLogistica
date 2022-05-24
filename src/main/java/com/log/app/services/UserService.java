package com.log.app.services;

import com.log.app.daos.IUsuarioDao;
import com.log.app.entidades.Usuario;
import com.log.app.exepciones.EmailYaExisteExeption;
import com.log.app.exepciones.LoginRequestIncorrectaExeption;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private IUsuarioDao userRepository;

    @Autowired
    private TipoUsuarioService tipoUserService;

    public UserService(IUsuarioDao userRepository) {
        this.userRepository = userRepository;
    }

    public Usuario createUser(String email, String password, String nombre, String apellido)
            throws EmailYaExisteExeption {
        if (userRepository.findByEmail(email) != null) {
            throw new EmailYaExisteExeption("El email ya existe");
        }

        Usuario user = new Usuario();
        user.setEmail(email);
        user.setPassword(password);
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setActive(true);
        user.setTipoUsuario(tipoUserService.findAll().get(0));
        // TODO: encriptar password
        return userRepository.save(user);

    }

    public Usuario createUser(Usuario user) {
        return userRepository.save(user);
    }

    public Usuario authenticateUsuario(String email, String password) throws LoginRequestIncorrectaExeption {
        Usuario usuario;

        // TODO: desencriptar password
        usuario = userRepository.findByEmailAndPassword(email, password);
        if (usuario == null) {
            throw new LoginRequestIncorrectaExeption("Email o contraseña incorrecta");
        }
        System.out.println(usuario);
        return usuario;
    }

}
