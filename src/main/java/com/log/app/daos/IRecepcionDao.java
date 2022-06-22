package com.log.app.daos;

import com.log.app.data.ReporteProductos;
import com.log.app.entidades.Recepcion;

import com.log.app.entidades.TipoEstadoRecepcion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

public interface IRecepcionDao extends JpaRepository<Recepcion, Long> {
    long countByEstadoRecepcion_TipoEstado(TipoEstadoRecepcion tipoEstado);

    List<Recepcion> findByFechaRecepcionIsBetween(Date fechaRecepcionStart, Date fechaRecepcionEnd);

    @Modifying
    @Transactional

    @Query(value = "select year(recepciones.fecha_recepcion) as year, month(recepciones.fecha_recepcion) as mes, " +

    // "tipo_productos.nombre, tipo_productos.id_tipo_prod as idTipoProd"
            " sum(cantidad) as cantidad from recepciones_productos " +
            "inner join recepciones on recepciones_productos.id_recepcion = recepciones.id_recepcion " +
            "inner join tipo_productos on tipo_productos.id_tipo_prod = recepciones_productos.id_tipo_producto "
            +
            "where  (recepciones.fecha_recepcion BETWEEN ?1 AND ?2) " +
            "GROUP BY month(recepciones.fecha_recepcion), year(recepciones.fecha_recepcion)  "
            + "order by year(recepciones.fecha_recepcion), month(recepciones.fecha_recepcion)",
            // tipo_productos.id_tipo_prod" +
            // "order by tipo_productos.id_tipo_prod ",
            nativeQuery = true)
    List<ReporteProductos> sumProductosSolicitadosByMonthBetweenFechas(Date fecharecepciontart,
            Date fecharecepcionEnd);



            @Modifying
    @Transactional

    @Query(value = "select year(recepciones.fecha_recepcion) as year, month(recepciones.fecha_recepcion) as mes, " +

    // "tipo_productos.nombre, tipo_productos.id_tipo_prod as idTipoProd"
            " sum(cantidad) as cantidad from recepciones_productos " +
            "inner join recepciones on recepciones_productos.id_recepcion = recepciones.id_recepcion " +
            "inner join tipo_productos on tipo_productos.id_tipo_prod = recepciones_productos.id_tipo_producto "
            +
            "where  (recepciones.fecha_recepcion BETWEEN ?1 AND ?2) and tipo_productos.id_tipo_prod = ?3" +
            "GROUP BY month(recepciones.fecha_recepcion), year(recepciones.fecha_recepcion)  "
            + "order by year(recepciones.fecha_recepcion), month(recepciones.fecha_recepcion)",
            // tipo_productos.id_tipo_prod" +
            // "order by tipo_productos.id_tipo_prod ",
            nativeQuery = true)
    List<ReporteProductos> sumProductosSolicitadosByMonthBetweenFechasByProducto(Date fecharecepciontart,
            Date fecharecepcionEnd, Long idTipoProd);
}
