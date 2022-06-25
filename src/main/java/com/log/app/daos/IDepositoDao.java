package com.log.app.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.log.app.entidades.Deposito;

public interface IDepositoDao extends CrudRepository<Deposito, Long> {
    
    List<Deposito> findAll();

}
