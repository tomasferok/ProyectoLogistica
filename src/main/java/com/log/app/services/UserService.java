package com.log.app.services;

import com.log.app.daos.IUsuarioDao;
import com.log.app.entidades.Usuario;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private IUsuarioDao userRepository;

    public UserService(IUsuarioDao userRepository) {
        this.userRepository = userRepository;
    }

    public Usuario createUser(Usuario user) {

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
