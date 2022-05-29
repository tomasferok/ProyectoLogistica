package com.log.app.services;

import com.log.app.daos.IProductoDao;
import com.log.app.entidades.Producto;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductoService {

    @Autowired
    IProductoDao productoDao;

    public Producto saveEmpyProducto(Producto producto) {
        producto.setCantidadDisponible(0);
        producto.setCantidadEnCuarentena(0);
        producto.setCantidadReservada(0);
        return productoDao.save(producto);

    }
}
