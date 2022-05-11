package com.log.app.services;

import java.util.List;

import com.log.app.entidades.Cliente;

public interface IClienteService {
	public List<Cliente> findAll();

	public Cliente save(Cliente cliente);
	
	public Cliente findOne(Long idCliente);
	
	public void delete(Long idCliente);
}
