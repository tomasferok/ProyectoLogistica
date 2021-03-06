package com.log.app.controllers;

import java.util.List;

import com.log.app.services.Impl.ProveedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.log.app.constants.Constants;
import com.log.app.entidades.Proveedor;
import com.log.app.services.Interfaces.IProveedorService;

/**
 * Controlador Rest para la clase Provedor
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "*" })

public class ProveedorRestController {

	@Autowired
	private ProveedorServiceImpl provService;

	
	/** 
	 * @return List<Proveedor>
	 */
	@GetMapping("/prov")
	public List<Proveedor> index() {

		return provService.findAll();
	}

	
	/** 
	 * @param idProv
	 * @return Proveedor
	 */
	@GetMapping("/prov/{idProv}")
	public Proveedor show(@PathVariable Long idProv) {

		return provService.findOne(idProv);
	}

	
	/** 
	 * @param nombre
	 * @return List<Proveedor>
	 */
	@GetMapping("/prov/search/nombre/{nombre}")
	public  List<Proveedor>  obtenerPorNombre(@PathVariable String nombre) {

		return provService.findByNombreProvIgnoreCaseContaining(nombre);
	}

	
	/** 
	 * @param prov
	 * @return Proveedor
	 */
	@PostMapping("/prov")
	@ResponseStatus(HttpStatus.CREATED)
	public Proveedor create(@RequestBody Proveedor prov) {
		return provService.save(prov);

	}

	
	/** 
	 * @param prov
	 * @param idProv
	 * @return Proveedor
	 */
	@PutMapping("/prov/{idProv}")
	public Proveedor update(@RequestBody Proveedor prov, @PathVariable Long idProv) {
		Proveedor provActual = provService.findOne(idProv);

		provActual.setNombreProv(prov.getNombreProv());
		provActual.setContacto(prov.getContacto());
		provActual.setEmail(prov.getEmail());

		return provService.save(provActual);
	}

	
	/** 
	 * @param idProv
	 */
	@DeleteMapping("/prov/{idProv}")
	public void delete(@PathVariable Long idProv) {
		provService.delete(idProv);
	}

	
}
