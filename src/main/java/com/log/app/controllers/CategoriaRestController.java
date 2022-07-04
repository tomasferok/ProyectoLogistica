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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.log.app.constants.Constants;
import com.log.app.entidades.Categoria;
import com.log.app.services.Interfaces.ICategoriaService;

/**
 * Controlador Rest para la clase categoria
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CategoriaRestController {

	@Autowired
	private ICategoriaService categoriaService;

	
	/** 
	 * @return List<Categoria>
	 */
	@GetMapping("/categoria")
	public List<Categoria> index() {
		return categoriaService.findAll();
	}

	
	/** 
	 * @param idCat
	 * @return Categoria
	 */
	@GetMapping("/categoria{idCat}")
	public Categoria show(@PathVariable Long idCat) {
		
		
		return categoriaService.findOne(idCat);
	}

	
	/** 
	 * @param categoria
	 * @return Categoria
	 */
	@PostMapping("/categoria")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria create(@RequestBody Categoria categoria) {
		return categoriaService.save(categoria);
		
}
	
	/** 
	 * @param categoria
	 * @param idCat
	 * @param flash
	 * @return Categoria
	 */
	@PutMapping("/categoria/{idCat}")
	public Categoria update(@RequestBody Categoria categoria, @PathVariable Long idCat, RedirectAttributes flash) {
		Categoria categoriaActual= categoriaService.findOne(idCat);
		
		
		if (idCat > 0) {
			categoria = categoriaService.findOne(idCat);
			if (categoria == null) {
				flash.addFlashAttribute("error", "El ID e la categoria no existe en la BBDD!");
				
			}
		} else {
			flash.addFlashAttribute("error", "El ID de la categoria no puede ser cero!");
			
		}
		categoriaActual.setNombre(categoria.getNombre());
		
		return categoriaService.save(categoriaActual);
	}
	
	
	/** 
	 * @param idCat
	 */
	@DeleteMapping("/categoria/{idCat}")
	public void delete(@PathVariable Long idCat) {
		categoriaService.delete(idCat);
	}
}
