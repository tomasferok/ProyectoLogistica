package com.log.app.services.Interfaces;

import java.util.List;

import com.log.app.entidades.Categoria;



public interface ICategoriaService {

	public List<Categoria> findAll();

	public Categoria save(Categoria categoria);
	
	public Categoria findOne(Long idCat);
	
	public void delete(Long idCat);
}
