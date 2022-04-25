package com.log.app.daos;

import com.log.app.entidades.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
    Usuario findByEmailAndPassword(String email, String password);
}
