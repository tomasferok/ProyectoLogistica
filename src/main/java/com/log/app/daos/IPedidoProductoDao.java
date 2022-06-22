package com.log.app.daos;

import com.log.app.entidades.PedidoProducto;
import org.springframework.data.repository.CrudRepository;

    public interface IPedidoProductoDao extends CrudRepository<PedidoProducto, Long> {


}
