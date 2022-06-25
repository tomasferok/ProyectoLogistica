package com.log.app.daos;

import org.springframework.data.repository.CrudRepository;

import com.log.app.entidades.Empresa;

public interface IEmpresaDao extends CrudRepository<Empresa, Long> {

}
