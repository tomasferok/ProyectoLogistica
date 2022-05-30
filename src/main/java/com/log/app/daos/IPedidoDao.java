package com.log.app.daos;

import com.log.app.entidades.Pedido;

import org.springframework.data.repository.CrudRepository;

public interface IPedidoDao extends CrudRepository<Pedido, Long> {


    
}
