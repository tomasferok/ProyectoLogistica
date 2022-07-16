package com.log.app.daos;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.log.app.data.ReporteCategorias;
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

}
