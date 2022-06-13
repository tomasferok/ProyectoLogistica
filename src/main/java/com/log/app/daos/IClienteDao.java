package com.log.app.daos;

import org.springframework.data.repository.CrudRepository;

import com.log.app.entidades.Cliente;

import java.util.List;

public interface IClienteDao extends CrudRepository<Cliente, Long> {


    public List<Cliente> findByDocumentoIgnoreCaseContaining(String documento);
}
