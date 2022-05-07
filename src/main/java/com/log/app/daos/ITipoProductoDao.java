package com.log.app.daos;

import org.springframework.data.repository.CrudRepository;

import com.log.app.entidades.TipoProducto;

public interface ITipoProductoDao extends CrudRepository<TipoProducto, Long>{

}
