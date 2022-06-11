package com.log.app.services;

import java.util.List;

import com.log.app.entidades.Proveedor;

public interface IProveedorService {

	
	public List<Proveedor> findAll();

	public Proveedor save(Proveedor proveedor);
	
	public Proveedor findOne(Long idProv);
	
	public void delete(Long idProv);

	public Proveedor findByNombreProvIgnoreCaseContaining(String nombre);

}
