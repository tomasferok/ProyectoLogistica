package com.log.app.services.Interfaces;

import com.log.app.entidades.Pedido;

public interface IPedidosService {
    public Pedido save(Pedido pedido);

    public Iterable<Pedido> findAll();
}
