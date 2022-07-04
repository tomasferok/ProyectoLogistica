package com.log.app.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.log.app.daos.ISubCategoriaDao;
import com.log.app.entidades.SubCategoria;
import com.log.app.services.Interfaces.ISubCategoriaService;

/**
 * Servicio de la entidad SubCategoria
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Service
public class SubCategoriaServiceImpl implements ISubCategoriaService {

	@Autowired
	ISubCategoriaDao subCategoDao;

	
	/** 
	 * @return List<SubCategoria>
	 */
	@Override
	@Transactional(readOnly = true)
	public List<SubCategoria> findAll() {
		// TODO Auto-generated method stub
		return (List<SubCategoria>) subCategoDao.findAll();
	}

	
	/** 
	 * @param subCat
	 * @return SubCategoria
	 */
	@Override
	@Transactional
	public SubCategoria save(SubCategoria subCat) {
		
		return subCategoDao.save(subCat);
	}

	
	/** 
	 * @param idSubCat
	 * @return SubCategoria
	 */
	@Override
	@Transactional(readOnly = true)
	public SubCategoria findOne(Long idSubCat) {
		// TODO Auto-generated method stub
		return subCategoDao.findById(idSubCat).orElse(null);
	}

	
	/** 
	 * @param idSubCat
	 */
	@Override
	@Transactional
	public void delete(Long idSubCat) {
		subCategoDao.deleteById(idSubCat);

	}

}
