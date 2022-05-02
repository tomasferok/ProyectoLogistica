package com.log.app.services;

import java.util.List;

import com.log.app.entidades.Categoria;



public interface ICategoriaService {

	public List<Categoria> findAll();

	public void save(Categoria categoria);
	
	public Categoria findOne(Long idCat);
	
	public void delete(Long idCat);
}
