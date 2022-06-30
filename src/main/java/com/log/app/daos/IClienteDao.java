package com.log.app.daos;

import org.springframework.data.repository.CrudRepository;

import com.log.app.entidades.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteDao extends CrudRepository<Cliente, Long> {


    public List<Cliente> findByDocumentoIgnoreCaseContaining(String documento);
    
    public Optional<Cliente> findByDocumento(String documento);

}
