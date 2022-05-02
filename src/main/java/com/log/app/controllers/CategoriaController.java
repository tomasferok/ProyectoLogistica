package com.log.app.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import com.log.app.entidades.Categoria;
import com.log.app.services.ICategoriaService;



@Controller
@SessionAttributes("categoria")
public class CategoriaController {

	@Autowired
	private ICategoriaService categoriaService;
	
	@RequestMapping(value="/listarCat", method=RequestMethod.GET)
	public String listarCat(Model model) {
		
		model.addAttribute("titulo", "Listado Categorias");
		
		model.addAttribute("categorias", categoriaService.findAll());
		return "listarCat";
	}
	
	
	@RequestMapping(value="/formCat")
	public String crearCat(Model model) {
		
		Categoria categoria = new Categoria();
		model.addAttribute("titulo", "Formulario de categorias");
		model.addAttribute("categoria", categoria);
		return "formCat";
	}
	
	@RequestMapping(value="/formCat{idCat}")
	public String editarCat(@PathVariable(value="idCat") Long idCat, Model model) {
		
		Categoria categoria = null;
		if(idCat>0) {
			categoria = categoriaService.findOne(idCat);
		} else {
			return "redirect:listarCat";
		}
		model.addAttribute("categoria",categoria);
		model.addAttribute("titulo", "Editar Categoria");
		
		
		return "formCat";
	}
	

	
	@RequestMapping(value="/formCat", method=RequestMethod.POST)
	public String guardarCat(@Valid Categoria categoria, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Categorias");
			return "formCat";
		}
		
		categoriaService.save(categoria);
		status.setComplete();
		return "redirect:listarCat";
	}
	@RequestMapping(value="/eliminar/{idCat}")
	public String eliminarCat(@PathVariable(value="idCat") Long id) {
		
		if(id > 0) {
			categoriaService.delete(id);
		}
		return "redirect:/listarCat";
	}
	
}
