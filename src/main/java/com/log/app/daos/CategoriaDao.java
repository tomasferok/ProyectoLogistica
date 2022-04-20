package com.log.app.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.log.app.entidades.Categoria;


@Repository("categoriaJPA")
public class CategoriaDao implements ICategoriaDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Categoria> findAll() {
		
		return em.createQuery("from Categoria").getResultList();
	}


	@Transactional
	@Override
	public void save(Categoria categoria) {
		em.persist(categoria);
		
	}
}
