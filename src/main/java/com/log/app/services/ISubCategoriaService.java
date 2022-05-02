package com.log.app.services;

import java.util.List;

import com.log.app.entidades.SubCategoria;



public interface ISubCategoriaService {

	public List<SubCategoria> findAll();

	public void save(SubCategoria subCat);
	
	public SubCategoria findOne(Long idSubCat);
	
	public void delete(Long idSubCat);

}
