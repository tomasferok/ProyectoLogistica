package com.log.app.daos;



import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.log.app.data.ReporteCategorias;
import com.log.app.entidades.Categoria;



public interface ICategoriaDao extends CrudRepository<Categoria, Long>{
	
    public List<Categoria> findAll();
    
   @Modifying
        @Transactional
        @Query(value = "SELECT CATEGORIAS.id_cat as idCat, CATEGORIAS.NOMBRE as nombreCat," +
                        " month(pedidos.fecha_pedido) as mes, " +
                        " year(pedidos.fecha_pedido) as year,  sum(cantidad) as cantidad " +
                        "FROM CATEGORIAS " +
                        " inner join tipo_productos on tipo_productos.categoria_id=CATEGORIAS.id_cat" +
                        " inner join pedidos_producto" +
                        " on pedidos_producto.id_tipo_producto=" +
                        " tipo_productos.id_tipo_prod inner" +
                        " join pedidos" +
                        " on pedidos_producto.id_pedido_producto=" +
                        " pedidos.id_pedido inner" +
                        " join pedidos_estado_pedido" +
                        " on pedidos_estado_pedido.pedido_id_pedido=" +
                        " pedidos.id_pedido inner" +
                        " join estado_pedido" +
                        " on estado_pedido.id_estado_pedido=" +
                        " pedidos_estado_pedido.estado_pedido_id_estado_pedido " +
                        " where (pedidos.fecha_pedido BETWEEN ?1 AND ?2)" +
                        " GROUP BY CATEGORIAS.id_cat," +
                        " month(pedidos.fecha_pedido);", nativeQuery = true)
        List<ReporteCategorias> sumProductosPorCategoriaByMonth(Date fechaPedidoStart, Date fechaPedidoEnd);

}
