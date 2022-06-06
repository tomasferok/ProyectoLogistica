package com.log.app.daos;

import com.log.app.entidades.Pedido;
import com.log.app.entidades.TipoEstadoPedido;

import org.springframework.data.repository.CrudRepository;

public interface IPedidoDao extends CrudRepository<Pedido, Long> {
    long countByEstadoPedido_TipoEstadoPedido(TipoEstadoPedido tipoEstadoPedido);




    
}
