package com.log.app.controllers;



import java.util.Map;

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
	
	@RequestMapping(value = "/listarCat", method = RequestMethod.GET)
	public String listarCat(Model model) {
		model.addAttribute("titulo", "Listado de Categorias");
		model.addAttribute("categorias", categoriaService.findAll());
		
		return "listarCat";
		
	}
	@RequestMapping(value = "/formCat")
	public String crearCat(Map<String, Object> model) {

		Categoria categoria = new Categoria();
		model.put("categoria", categoria);
		model.put("titulo", "Formulario de Categorias");
		return "formCat";
	}
	@RequestMapping(value="/formCat/{idCat}")
	public String editarSubCat(@PathVariable(value="idCat") Long idCat, Map<String, Object> model) {
		
		Categoria categoria = null;
		
		if(idCat > 0) {
			categoria = categoriaService.findOne(idCat);
		} else {
			return "redirect:/listarCat";
		}
		model.put("categoria", categoria);
		model.put("titulo", "Editar Categoria");
		return "formCat";
	}
	@RequestMapping(value = "/formCat", method = RequestMethod.POST)
	public String guardar(@Valid Categoria categoria, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Categorias");
			return "formCat";
		}
		
		categoriaService.save(categoria);
		status.setComplete();
		return "redirect:listarCat";
	}
	
	@RequestMapping(value="/eliminarCat/{idCat}")
	public String eliminar(@PathVariable(value="idCat") Long idCat) {
		
		if(idCat > 0) {
			categoriaService.delete(idCat);
		}
		return "redirect:/listarCat";
	}
}
