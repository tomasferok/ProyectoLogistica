package com.log.app.daos;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

import com.log.app.entidades.TipoProducto;

public interface ITipoProductoDao extends CrudRepository<TipoProducto, Long> {
    List<TipoProducto> findByProvedor_IdProv(Long idProv);

    List<TipoProducto> findByNombreIgnoreCaseContaining(String nombre);

    TipoProducto findByCodigoDeBarras(Long codigoDeBarras);

}
