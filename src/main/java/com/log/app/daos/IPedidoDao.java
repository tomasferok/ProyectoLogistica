package com.log.app.daos;

import com.log.app.entidades.Pedido;
import com.log.app.entidades.TipoEstadoPedido;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IPedidoDao extends CrudRepository<Pedido, Long> {
    long countByEstadoPedido_TipoEstadoPedido(TipoEstadoPedido tipoEstadoPedido);

    List<Pedido> findByFechaPedidoIsBetween(Date fechaPedidoStart, Date fechaPedidoEnd);

    List<Pedido> findByfechaPedido(Date fecha);

}
