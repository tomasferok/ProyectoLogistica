package com.log.app.daos;

import com.log.app.entidades.Producto;

import org.springframework.data.repository.CrudRepository;

public interface IProductoDao extends CrudRepository<Producto, Long> {

}
    

