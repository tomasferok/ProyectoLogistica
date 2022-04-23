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

   public Usuario createUser (Usuario user) {
       return userRepository.save(user);
    }

    


}
