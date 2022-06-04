package com.log.app.services;

import com.log.app.daos.IPedidoDao;
import com.log.app.entidades.Pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidosService implements IPedidosService {

    @Autowired
    private IPedidoDao pedidosDao;

    @Override
    public Pedido save(Pedido pedido) {

        try {

        return pedidosDao.save(pedido);
        }catch(

    Exception e)
    {
        // TODO: handle exceptio
        System.out.println(e.getMessage());
        return null;
    }
    }

    public Iterable<Pedido> findAll() {
        return pedidosDao.findAll();
    }

}
