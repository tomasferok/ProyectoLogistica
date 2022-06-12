package com.log.app.services.Interfaces;

import java.util.List;

import com.log.app.entidades.Distribuidor;

public interface IDistribuidorService {

	public List<Distribuidor> findAll();

	public Distribuidor save(Distribuidor distribuidor);
	
	public Distribuidor findOne(Long idDistribu);
	
	public void delete(Long idDistribu);
}
