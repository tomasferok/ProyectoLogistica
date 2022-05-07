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

import com.log.app.entidades.Categoria;
import com.log.app.services.ICategoriaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CategoriaRestController {

	@Autowired
	private ICategoriaService categoriaService;

	@GetMapping("/categoria")
	public List<Categoria> index() {

		return categoriaService.findAll();
	}

	@GetMapping("/categoria{idCat}")
	public Categoria show(@PathVariable Long idCat) {

		return categoriaService.findOne(idCat);
	}

	@PostMapping("/categoria")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria create(@RequestBody Categoria categoria) {
		return categoriaService.save(categoria);
		
}
	@PutMapping("/categoria/{idCat}")
	public Categoria update(@RequestBody Categoria categoria, @PathVariable Long idCat) {
		Categoria categoriaActual= categoriaService.findOne(idCat);
		
		categoriaActual.setNombre(categoria.getNombre());
		
		return categoriaService.save(categoriaActual);
	}
	
	@DeleteMapping("/categoria/{idCat}")
	public void delete(@PathVariable Long idCat) {
		categoriaService.delete(idCat);
	}
}
	
	

	

