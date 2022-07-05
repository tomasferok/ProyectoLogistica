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

import com.log.app.constants.Constants;
import com.log.app.entidades.SubCategoria;
import com.log.app.services.Interfaces.ISubCategoriaService;

/**
 * Controlador Rest para la clase Sub Categoria
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "*" })
public class SubCategoriaRestController {
	@Autowired
	private ISubCategoriaService subCatService;
	/** 
	 * @return List<SubCategoria>
	 */
	

	@GetMapping("/subCat")
	public List<SubCategoria> index() {
		return subCatService.findAll();
	}
	/** 
	 * @param idSubCat
	 * @return SubCategoria
	 */
	

	@GetMapping("/SubCat/{idSubCat}")
	public SubCategoria show(@PathVariable Long idSubCat) {

		return subCatService.findOne(idSubCat);
	}
	/** 
	 * @param subCat
	 * @return SubCategoria
	 */
	

	@PostMapping("/subCat")
	@ResponseStatus(HttpStatus.CREATED)
	public SubCategoria create(@RequestBody SubCategoria subCat) {
		return subCatService.save(subCat);
		
		/** 
		 * @param subCat
		 * @param idSubCat
		 * @return SubCategoria
		 */
		
}
	@PutMapping("/subCat/{idSubCat}")
	public SubCategoria update(@RequestBody SubCategoria subCat, @PathVariable Long idSubCat) {
		SubCategoria subCatActual= subCatService.findOne(idSubCat);
		
		subCatActual.setNombre(subCat.getNombre());
		
		return subCatService.save(subCatActual);
	}
	/** 
	 * @param idSubCat
	 */
	
	
	@DeleteMapping("/subCat/{idSubCat}")
	public void delete(@PathVariable Long idSubCat) {
		subCatService.delete(idSubCat);
	}
}
