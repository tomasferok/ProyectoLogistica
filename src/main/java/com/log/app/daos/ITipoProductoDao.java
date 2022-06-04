package com.log.app.daos;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.log.app.entidades.TipoProducto;

public interface ITipoProductoDao extends CrudRepository<TipoProducto, Long>{
    List<TipoProducto> findByProvedor_IdProv(Long idProv);



    

}
