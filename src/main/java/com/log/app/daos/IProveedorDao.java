package com.log.app.daos;

import org.springframework.data.repository.CrudRepository;

import com.log.app.entidades.Proveedor;

import java.util.List;

public interface IProveedorDao extends CrudRepository<Proveedor, Long>{

    public List<Proveedor> findByNombreProvIgnoreCaseContaining(String nombreProv);
    

}
