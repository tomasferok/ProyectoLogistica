package com.log.app.daos;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.log.app.entidades.Categoria;



public interface ICategoriaDao extends CrudRepository<Categoria, Long>{
	
    public List<Categoria> findAll();
    

}
