package com.log.app.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.app.daos.IClienteDao;
import com.log.app.entidades.Cliente;
import com.log.app.services.Interfaces.IClienteService;

/**
 * Servicio de la entidad cliente
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	IClienteDao clienteDao;
	/** 
	 * @return List<Cliente>
	 */

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	
	/** 
	 * @param cliente
	 * @return Cliente
	 */
	}

	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.save(cliente);
	
	/** 
	 * @param idCliente
	 * @return Cliente
	 */
	}

	@Override
	public Cliente findOne(Long idCliente) {
		// TODO Auto-generated method stub
		return clienteDao.findById(idCliente).orElse(null);
	
	/** 
	 * @param idCliente
	 */
	}

	@Override
	public void delete(Long idCliente) {
		clienteDao.deleteById(idCliente);
	}
	/** 
	 * @param documento
	 * @return List<Cliente>
	 */
	


	@Override
	public List<Cliente> findByDocumentoIgnoreCaseContaining(String documento) {
		// TODO Auto-generated method stub
		return clienteDao.findByDocumentoIgnoreCaseContaining(documento);
	}
}
