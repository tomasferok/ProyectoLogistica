package com.log.app.daos;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.log.app.data.ReporteCategorias;
import com.log.app.data.ReporteProductosInterface;
import com.log.app.entidades.Categoria;

public interface ICategoriaDao extends CrudRepository<Categoria, Long> {

    public List<Categoria> findAll();

    @Modifying
    @Transactional
    @Query(value = "SELECT categorias.id_cat as idCat, " +
            "categorias.NOMBRE as nombreCat," +
            " month(pedidos.fecha_pedido) as mes, " +
            " year(pedidos.fecha_pedido) as year,  sum(cantidad) as cantidad " +
            "FROM categorias " +
            " inner join tipo_productos on tipo_productos.categoria_id=categorias.id_cat" +
            " inner join pedidos_producto" +
            " on pedidos_producto.id_tipo_producto=" +
            " tipo_productos.id_tipo_prod inner" +
            " join pedidos" +
            " on pedidos_producto.id_pedido_producto=" +
            " pedidos.id_pedido" +
            " where (pedidos.fecha_pedido BETWEEN ?1 AND ?2)" +
            " GROUP BY categorias.id_cat," +
            " month(pedidos.fecha_pedido), year(pedidos.fecha_pedido);", nativeQuery = true)
    List<ReporteCategorias> sumProductosPorCategoriaByMonth(Date fechaPedidoStart, Date fechaPedidoEnd);

    @Modifying
    @Transactional

    @Query(value = "select year(pedidos.fecha_pedido) as year, month(pedidos.fecha_pedido) as mes, " +
            " sum(cantidad) as cantidad from pedidos_producto " +
            "inner join pedidos on pedidos_producto.id_pedido = pedidos.id_pedido " +
            "inner join tipo_productos on tipo_productos.id_tipo_prod = pedidos_producto.id_tipo_producto "
            + "inner join categorias on categorias.id_cat = tipo_productos.categoria_id " +
            "where  (pedidos.fecha_pedido BETWEEN ?1 AND ?2) " +
            "and  categorias.id_cat = ?3 " +
            "GROUP BY month(pedidos.fecha_pedido), year(pedidos.fecha_pedido) "
            + "order by year(pedidos.fecha_pedido), month(pedidos.fecha_pedido)", nativeQuery = true)
    List<ReporteProductosInterface> sumProductosVendidosByMonthBetweenFechasByCategoria(Date fechaPedidoStart,
            Date fechaPedidoEnd, Long idCat);

    @Modifying
    @Transactional

    @Query(value = "select year(recepciones.fecha_recepcion) as year, month(recepciones.fecha_recepcion) as mes,  " +
            " sum(cantidad) as cantidad from recepciones_productos  " +
            "inner join recepciones on recepciones_productos.id_recepcion = recepciones.id_recepcion " +
            " inner join tipo_productos on tipo_productos.id_tipo_prod = recepciones_productos.id_tipo_producto "
            + " inner join categorias on categorias.id_cat = tipo_productos.categoria_id  " +
            "where  (recepciones.fecha_recepcion BETWEEN ?1 AND ?2) " +
            "and  categorias.id_cat = ?3 " +
            "GROUP BY month(recepciones.fecha_recepcion), year(recepciones.fecha_recepcion) "
            + "order by year(recepciones.fecha_recepcion), month(recepciones.fecha_recepcion)", nativeQuery = true)
    List<ReporteProductosInterface> sumProductosSolicitadosByMonthBetweenFechasByCategoria(Date fechaPedidoStart,
            Date fechaPedidoEnd, Long idCat);
}
