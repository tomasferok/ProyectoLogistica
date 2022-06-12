package com.log.app.controllers;

import java.util.List;

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

import com.log.app.entidades.Distribuidor;
import com.log.app.services.Interfaces.IDistribuidorService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class DistribuidorRestController {
	@Autowired
	private IDistribuidorService distService;

	@GetMapping("/dist")
	public List<Distribuidor> index() {

		return distService.findAll();
	}

	@GetMapping("/dist/{idDistribu}")
	public Distribuidor show(@PathVariable Long idDistribu) {

		return distService.findOne(idDistribu);
	}

	@PostMapping("/dist")
	@ResponseStatus(HttpStatus.CREATED)
	public Distribuidor create(@RequestBody Distribuidor dist) {
		return distService.save(dist);
		
}
	@PutMapping("/dist/{idDistribu}")
	public Distribuidor update(@RequestBody Distribuidor dist, @PathVariable Long idDistribu) {
		Distribuidor distActual= distService.findOne(idDistribu);
		
		distActual.setVehiculo(dist.getVehiculo());
		distActual.setMatricula(dist.getMatricula());
		distActual.setChofer(dist.getChofer());
	
		
		return distService.save(distActual);
	}
	
	@DeleteMapping("/dist/{idDistribu}")
	public void delete(@PathVariable Long idDistribu) {
		distService.delete(idDistribu);
	}
}
