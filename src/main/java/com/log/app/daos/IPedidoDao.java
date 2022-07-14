package com.log.app.daos;

import com.log.app.data.ReporteProductos;
import com.log.app.entidades.Pedido;
import com.log.app.entidades.TipoEstadoPedido;
import com.log.app.entidades.TipoProducto;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IPedidoDao extends CrudRepository<Pedido, Long> {
        long countByEstadoPedido_TipoEstadoPedido(TipoEstadoPedido tipoEstadoPedido);

        List<Pedido> findByFechaPedidoIsBetween(Date fechaPedidoStart, Date fechaPedidoEnd);

        List<Pedido> findByfechaPedido(Date fecha);

        List<Pedido> findAll();

        long countByFechaPedidoIsBetween(Date fechaPedidoStart, Date fechaPedidoEnd);

        @Query(value = "select sum(cantidad) from pedidos_producto "
                        +
                        "inner join pedidos on pedidos_producto.pedido_id_pedido = pedidos.id_pedido" +
                        "where  (pedidos.fecha_pedido BETWEEN ?1 AND ?2", nativeQuery = true)
        long sumProductosVendidosByBetweenFecha(Date fechaPedidoStart, Date fechaPedidoEnd);

        @Modifying
        @Transactional

        @Query(value = "select year(pedidos.fecha_pedido) as year, month(pedidos.fecha_pedido) as mes, " +
                        " sum(cantidad) as cantidad from pedidos_producto " +
                        "inner join pedidos on pedidos_producto.id_pedido = pedidos.id_pedido " +
                        "inner join tipo_productos on tipo_productos.id_tipo_prod = pedidos_producto.id_tipo_producto "
                        +
                        "where  (pedidos.fecha_pedido BETWEEN ?1 AND ?2) " +
                        "GROUP BY month(pedidos.fecha_pedido), year(pedidos.fecha_pedido) "
                        + "order by year(pedidos.fecha_pedido), month(pedidos.fecha_pedido)", nativeQuery = true)
        List<ReporteProductos> sumProductosVendidosByMonthBetweenFechas(Date fechaPedidoStart,
                        Date fechaPedidoEnd);

        @Modifying
        @Transactional

        @Query(value = "select year(pedidos.fecha_pedido) as year, month(pedidos.fecha_pedido) as mes, " +
                        " sum(cantidad) as cantidad from pedidos_producto " +
                        "inner join pedidos on pedidos_producto.id_pedido = pedidos.id_pedido " +
                        "inner join tipo_productos on tipo_productos.id_tipo_prod = pedidos_producto.id_tipo_producto "+
                        "where  (pedidos.fecha_pedido BETWEEN ?1 AND ?2) and pedidos_producto.id_tipo_producto = ?3 " +
                        "GROUP BY month(pedidos.fecha_pedido)"
                        + "order by year(pedidos.fecha_pedido), month(pedidos.fecha_pedido)",
                        nativeQuery = true)
        List<ReporteProductos> sumProductosVendidosByMonthBetweenFechasByTipoProducto(Date fechaPedidoStart,
                        Date fechaPedidoEnd, long idTipoProducto);


        @Modifying
        @Transactional

List<ReporteProductos> sumProductosPorCategoriaByMonth (Date fechaPedidoStart, Date fechaPedidoEnd);

}
