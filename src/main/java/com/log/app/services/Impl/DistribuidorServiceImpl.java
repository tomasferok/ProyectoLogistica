package com.log.app.services.Impl;

import java.util.List;

import com.log.app.services.IDistribuidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.app.daos.IDistribuidorDao;
import com.log.app.entidades.Distribuidor;

@Service
public class DistribuidorServiceImpl implements IDistribuidorService {

	@Autowired
	IDistribuidorDao distribuidorService;

	@Override
	public List<Distribuidor> findAll() {
		// TODO Auto-generated method stub
		return (List<Distribuidor>) distribuidorService.findAll();
	}

	@Override
	public Distribuidor save(Distribuidor distribuidor) {
		// TODO Auto-generated method stub
		return distribuidorService.save(distribuidor);
	}

	@Override
	public Distribuidor findOne(Long idDistribu) {
		// TODO Auto-generated method stub
		return distribuidorService.findById(idDistribu).orElse(null);
	}

	@Override
	public void delete(Long idDistribu) {
		distribuidorService.deleteById(idDistribu);
	}

}
