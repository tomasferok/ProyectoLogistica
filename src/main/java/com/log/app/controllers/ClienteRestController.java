package com.log.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.log.app.entidades.Cliente;
import com.log.app.services.Interfaces.IClienteService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private IClienteService cliService;

	@GetMapping("/cli")
	public List<Cliente> index() {

		return cliService.findAll();
	}

	@GetMapping("/cli/{idCliente}")
	public Cliente show(@PathVariable Long idCliente) {

		return cliService.findOne(idCliente);
	}
	@GetMapping("/cli/search/")
	public List<Cliente> findByDocument(@RequestParam(name = "documento") String documento) {
		return cliService.findByDocumentoIgnoreCaseContaining(documento);
	}

	@PostMapping("/cli")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cli) {
		return cliService.save(cli);
		
}
	@PutMapping("/cli/{idCliente}")
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
	
	@DeleteMapping("/cli/{idCliente}")
	public void delete(@PathVariable Long idCliente) {
		cliService.delete(idCliente);
	}
}



