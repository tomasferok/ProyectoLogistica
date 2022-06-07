package com.log.app.daos;

import com.log.app.entidades.RecepcionProducto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecepcionProductosRepository extends CrudRepository<RecepcionProducto, Long> {

    @Query(value = "Select * from Recepcion_Productos where id_recepcion_producto = ?1", nativeQuery = true)
    List<RecepcionProducto> findAllById(Integer id);
}
