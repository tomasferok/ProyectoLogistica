package com.log.app.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.app.daos.IProveedorDao;
import com.log.app.entidades.Proveedor;
import com.log.app.services.Interfaces.IProveedorService;

/**
 * Servicio de la entidad Proveedor
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Service
public class ProveedorServiceImpl implements IProveedorService {

	@Autowired
	private IProveedorDao proveedorDao
	/**
	 * @return List<Proveedor>
	 */
	;

	@Override
	public List<Proveedor> findAll() {
		// TODO Auto-generated method stub
		return (List<Proveedor>) proveedorDao.findAll();

	}

	/**
	 * @param proveedor
	 * @return Proveedor
	 */
	@Override
	public Proveedor save(Proveedor proveedor) {
		proveedor.setEmail(proveedor.getEmail().toLowerCase());
	    proveedor.setNombreProv(proveedor.getNombreProv().toUpperCase());
		return proveedorDao.save(proveedor);

	}

	/**
	 * @param idProv
	 * @return Proveedor
	 */
	@Override
	public Proveedor findOne(Long idProv) {
		// TODO Auto-generated method stub
		return proveedorDao.findById(idProv).orElse(null);

	}

	/**
	 * @param idProv
	 */
	@Override
	public void delete(Long idProv) {

		proveedorDao.deleteById(idProv);

	}

	/**
	 * @param nombre
	 * @return List<Proveedor>
	 */
	@Override
	public List<Proveedor> findByNombreProvIgnoreCaseContaining(String nombre) {
		// TODO Auto-generated method stub
		return proveedorDao.findByNombreProvIgnoreCaseContaining(nombre);
	}

}
