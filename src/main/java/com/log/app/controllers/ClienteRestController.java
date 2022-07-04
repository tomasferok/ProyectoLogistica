package com.log.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.log.app.entidades.Cliente;
import com.log.app.services.Interfaces.IClienteService;


/**
 * Controlador Rest para la clase Cliente
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private IClienteService cliService;

	@G
	/** 
	 * @return List<Cliente>
	 */
	etMapping("/cli")
	public List<Cliente> index() {

		return cliService.findAll();
	}

	@G
	/** 
	 * @param idCliente
	 * @return Cliente
	 */
	etMapping("/cli/{idCliente}")
	public Cliente show(@PathVariable Long idCliente) {

		return cliService.findOne(idCliente);
	}
	@G
	/** 
	 * @param documento
	 * @return List<Cliente>
	 */
	etMapping("/cli/search/")
	public List<Cliente> findByDocument(@RequestParam(name = "documento") String documento) {
		return cliService.findByDocumentoIgnoreCaseContaining(documento);
	}

	@P
	/** 
	 * @param cli
	 * @return Cliente
	 */
	ostMapping("/cli")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cli) {
		return cliService.save(cli);
		
}
	@P
	/** 
	 * @param cli
	 * @param idCliente
	 * @return Cliente
	 */
	utMapping("/cli/{idCliente}")
	public Cliente update(@RequestBody Cliente cli, @PathVariable Long idCliente) {
		Cliente cliActual= cliService.findOne(idCliente);
		
		cliActual.setNombre(cli.getNombre());
		cliActual.setTelefono(cli.getTelefono());
		cliActual.setRazonSocial(cli.getRazonSocial());
		cliActual.setEmail(cli.getEmail());
		cliActual.setDocumento(cli.getDocumento());
		cliActual.setDireccion(cli.getDireccion());
		cliActual.setCiudad(cli.getCiudad());
		
		
	
		
		return cliService.save(cliActual);
	}
	
	@D
	/** 
	 * @param idCliente
	 */
	eleteMapping("/cli/{idCliente}")
	public void delete(@PathVariable Long idCliente) {
		cliService.delete(idCliente);
	}
}



