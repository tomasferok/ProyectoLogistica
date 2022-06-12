package com.log.app.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.app.daos.IClienteDao;
import com.log.app.entidades.Cliente;
import com.log.app.services.Interfaces.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	IClienteDao clienteService;
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteService.findAll();
	}

	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteService.save(cliente);
	}

	@Override
	public Cliente findOne(Long idCliente) {
		// TODO Auto-generated method stub
		return clienteService.findById(idCliente).orElse(null);
	}

	@Override
	public void delete(Long idCliente) {
		clienteService.deleteById(idCliente);		
	}

}
