package com.log.app.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.log.app.entidades.Empresa;
import com.log.app.entidades.Espacio;

public interface IEspacioDao extends CrudRepository<Espacio, Long> {
    
    public List<Espacio> findAll();
}
