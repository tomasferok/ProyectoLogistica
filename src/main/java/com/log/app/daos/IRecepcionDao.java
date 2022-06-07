package com.log.app.daos;

import com.log.app.entidades.Recepcion;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IRecepcionDao extends CrudRepository<Recepcion, Long> {

    @Query(value = "Select if(max(r.id_recepcion) is null, 1, max(r.id_recepcion)+1) from recepciones r", nativeQuery = true)
    Integer getCodeRecepcion();
    
}
