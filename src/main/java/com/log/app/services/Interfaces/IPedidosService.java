package com.log.app.services.Interfaces;

import java.util.List;

import com.log.app.entidades.Pedido;

public interface IPedidosService {
    public Pedido save(Pedido pedido);

    public List<Pedido> findAll();
}
