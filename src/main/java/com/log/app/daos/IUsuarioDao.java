package com.log.app.daos;

import com.log.app.entidades.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
    Usuario findByEmailAndPassword(String email, String password);
    Usuario findByEmail(String email);
    void deleteByEmail(String email);
}
