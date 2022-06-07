package com.log.app.services.Impl;

import java.util.List;

import com.log.app.services.ISubCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.log.app.daos.ISubCategoriaDao;
import com.log.app.entidades.SubCategoria;

@Service
public class SubCategoriaServiceImpl implements ISubCategoriaService {

	@Autowired
	ISubCategoriaDao subCategoDao;

	@Override
	@Transactional(readOnly = true)
	public List<SubCategoria> findAll() {
		// TODO Auto-generated method stub
		return (List<SubCategoria>) subCategoDao.findAll();
	}

	@Override
	@Transactional
	public SubCategoria save(SubCategoria subCat) {
		
		return subCategoDao.save(subCat);
	}

	@Override
	@Transactional(readOnly = true)
	public SubCategoria findOne(Long idSubCat) {
		// TODO Auto-generated method stub
		return subCategoDao.findById(idSubCat).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long idSubCat) {
		subCategoDao.deleteById(idSubCat);

	}

}
