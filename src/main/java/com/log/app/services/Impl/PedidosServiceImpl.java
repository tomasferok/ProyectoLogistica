package com.log.app.services.Impl;

import com.log.app.daos.IPedidoDao;
import com.log.app.entidades.Pedido;

import com.log.app.services.IPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidosServiceImpl implements IPedidosService {

    @Autowired
    private IPedidoDao pedidosDao;

    @Override
    public Pedido save(Pedido pedido) {
        return pedidosDao.save(pedido);
    }

    public Iterable<Pedido> findAll() {
        return pedidosDao.findAll();
    }

}
