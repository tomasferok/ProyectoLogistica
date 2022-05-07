package com.log.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.log.app.daos.ICategoriaDao;
import com.log.app.entidades.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private ICategoriaDao categoriaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return (List<Categoria>) categoriaDao.findAll();
	}

	@Override
	@Transactional
	public Categoria save(Categoria categoria) {
		return categoriaDao.save(categoria);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Categoria findOne(Long idCat) {
		// TODO Auto-generated method stub
		return categoriaDao.findById(idCat).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long idCat) {
		categoriaDao.deleteById(idCat);		
	}

}
