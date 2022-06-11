package com.log.app.daos;

import org.springframework.data.repository.CrudRepository;

import com.log.app.entidades.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
