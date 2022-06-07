package com.log.app.daos;

import java.util.List;

import com.log.app.entidades.Producto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoDao extends CrudRepository<Producto, Long> {

    //List<Producto> findByCantidadDisponibleGreaterThan(double cantidadDisponible);

    @Query(value = "Select * from productos", nativeQuery = true)
    List<Producto> findAllProductos();

    @Query(value = "Update producto p set p.cantidad_disponible = ?2 where id_prod = ?1", nativeQuery = true)
    Producto updateStockProducto(Long idProd, Double cantidad);
}
