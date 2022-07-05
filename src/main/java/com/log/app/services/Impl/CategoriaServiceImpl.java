package com.log.app.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.log.app.daos.ICategoriaDao;
import com.log.app.entidades.Categoria;
import com.log.app.services.Interfaces.ICategoriaService;

/**
 * Servicio de la entidad Categoria
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private ICategoriaDao categoriaDao;
	/** 
	 * @return List<Categoria>
	 */
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return categoriaDao.findAll();
	}

	@Override
	@Transactional
	public Categoria save(Categoria categoria) {
		return categoriaDao.
		/** 
		 * @param idCat
		 * @return Categoria
		 */
		save(categoria);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Categoria findOne(Long idCat) {
		// TODO Auto-generated method stub
		return categoriaDao.findById(
		/** 
		 * @param idCat
		 */
		idCat).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long idCat) {
		categoriaDao.deleteById(idCat);		
	}

}
