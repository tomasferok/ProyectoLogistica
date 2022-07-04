package com.log.app.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.app.daos.IDistribuidorDao;
import com.log.app.entidades.Distribuidor;
import com.log.app.services.Interfaces.IDistribuidorService;

/**
 * Servicio de la entidad Distribuidor
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Service
public class DistribuidorServiceImpl implements IDistribuidorService {

	@Autowired
	IDistribuidorDao distribuidorService;
	/** 
	 * @return List<Distribuidor>
	 */
	

	@Override
	public List<Distribuidor> findAll() {
		// TODO Auto-generated method stub
		return (List<Distribuidor>) distribuidorService.findAll(
		/** 
		 * @param distribuidor
		 * @return Distribuidor
		 */
		);
	}

	@Override
	public Distribuidor save(Distribuidor distribuidor) {
		// TODO Auto-generated method stub
		return distribuidorService.save(distribuidor
		/** 
		 * @param idDistribu
		 * @return Distribuidor
		 */
		);
	}

	@Override
	public Distribuidor findOne(Long idDistribu) {
		// TODO Auto-generated method stub
		return distribuidorService.findById(idDistribu).orElse(null
		/** 
		 * @param idDistribu
		 */
		);
	}

	@Override
	public void delete(Long idDistribu) {
		distribuidorService.deleteById(idDistribu);
	}

}
