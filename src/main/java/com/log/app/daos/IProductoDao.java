package com.log.app.daos;

import java.util.List;

import com.log.app.entidades.Producto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


public interface IProductoDao extends CrudRepository<Producto, Long> {

    List<Producto> findByCantidadDisponibleGreaterThan(double cantidadDisponible);

    Producto findByTipoProducto_idTipoProd(Long idTipoProd);
}
