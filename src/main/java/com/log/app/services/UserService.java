package com.log.app.services;

import com.log.app.daos.IUsuarioDao;
import com.log.app.entidades.Usuario;

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

    public Usuario createUser(String email, String password, String nombre, String apellido) {
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

    public Usuario authenticateUsuario(String email, String password) {
        Usuario usuario;

        try {

            // TODO: desencriptar password
            usuario = userRepository.findByEmailAndPassword(email, password);
            if (usuario == null) {
                throw new Exception("Usuario o contraseña incorrectos");
            }

        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("Usuario no encontrado");
        }
        return usuario;
    }

}
