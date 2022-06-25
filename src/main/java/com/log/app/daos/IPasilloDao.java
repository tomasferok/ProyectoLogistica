package com.log.app.daos;

import org.springframework.data.repository.CrudRepository;

import com.log.app.entidades.Pasillo;

public interface IPasilloDao extends CrudRepository<Pasillo, Long> {
    
}
