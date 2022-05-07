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

import com.log.app.entidades.SubCategoria;
import com.log.app.services.ISubCategoriaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class SubCategoriaRestController {
	@Autowired
	private ISubCategoriaService subCatService;

	@GetMapping("/subCat")
	public List<SubCategoria> index() {

		return subCatService.findAll();
	}

	@GetMapping("/SubCat/{idSubCat}")
	public SubCategoria show(@PathVariable Long idSubCat) {

		return subCatService.findOne(idSubCat);
	}

	@PostMapping("/subCat")
	@ResponseStatus(HttpStatus.CREATED)
	public SubCategoria create(@RequestBody SubCategoria subCat) {
		return subCatService.save(subCat);
		
}
	@PutMapping("/subCat/{idSubCat}")
	public SubCategoria update(@RequestBody SubCategoria subCat, @PathVariable Long idSubCat) {
		SubCategoria subCatActual= subCatService.findOne(idSubCat);
		
		subCatActual.setNombre(subCat.getNombre());
		
		return subCatService.save(subCatActual);
	}
	
	@DeleteMapping("/subCat/{idSubCat}")
	public void delete(@PathVariable Long idSubCat) {
		subCatService.delete(idSubCat);
	}
}
