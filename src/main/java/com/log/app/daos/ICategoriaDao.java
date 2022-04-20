package com.log.app.daos;

import java.util.List;

import com.log.app.entidades.Categoria;

public interface ICategoriaDao {
	
	public List<Categoria>findAll();
	public void save(Categoria categoria);

}
