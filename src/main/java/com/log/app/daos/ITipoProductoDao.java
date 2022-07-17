package com.log.app.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.log.app.data.ReporteProductosInterface;
import com.log.app.entidades.TipoProducto;
import com.log.app.helpers.ReporteProductosMasVendidos;

public interface ITipoProductoDao extends CrudRepository<TipoProducto, Long> {
    List<TipoProducto> findByProvedor_IdProv(Long idProv);

    List<TipoProducto> findByNombreIgnoreCaseContaining(String nombre);

    TipoProducto findByCodigoDeBarras(Integer codigoDeBarras);

    @Query(value = "select " +

            "tipo_productos.nombre as nombre, tipo_productos.id_tipo_prod as idTipoProd," +
            " sum(cantidad) as cantidad from pedidos_producto " +
            "inner join pedidos on pedidos_producto.id_pedido = pedidos.id_pedido " +
            "inner join tipo_productos on tipo_productos.id_tipo_prod = pedidos_producto.id_tipo_producto "
            +
            "where pedidos.fecha_pedido BETWEEN ?1 AND ?2 " 
           
            + " GROUP BY tipo_productos.id_tipo_prod order by cantidad DESC" +
            " limit 5", nativeQuery = true)
    List<ReporteProductosMasVendidos> productosMasVendidos(Date fecharecepciontart,
            Date fecharecepcionEnd);
}
