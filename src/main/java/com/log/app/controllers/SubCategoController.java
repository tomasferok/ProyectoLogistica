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


import com.log.app.entidades.SubCategoria;
import com.log.app.services.ISubCategoriaService;

@Controller
@SessionAttributes("subCategoria")
public class SubCategoController {

	@Autowired
	private ISubCategoriaService subCategoriaService;
	
	@RequestMapping(value = "/listarSubCat", method = RequestMethod.GET)
	public String listarSubCat(Model model) {
		model.addAttribute("titulo", "Listado de Sub Categorias");
		model.addAttribute("subcats", subCategoriaService.findAll());
		
		return "listarSubCat";
		
	}
	@RequestMapping(value = "/formSubCat")
	public String crearSubCat(Map<String, Object> model) {

		SubCategoria subCat = new SubCategoria();
		model.put("subCat", subCat);
		model.put("titulo", "Formulario de SubCategorias");
		return "formSubCat";
	}
	@RequestMapping(value="/formSubCat/{idSubCat}")
	public String editarSubCat(@PathVariable(value="idSubCat") Long idSubCat, Map<String, Object> model) {
		
		SubCategoria subCat = null;
		
		if(idSubCat > 0) {
			subCat = subCategoriaService.findOne(idSubCat);
		} else {
			return "redirect:/listarSubCat";
		}
		model.put("subCat", subCat);
		model.put("titulo", "Editar SubCategoria");
		return "formSubCat";
	}
	@RequestMapping(value = "/formSubCat", method = RequestMethod.POST)
	public String guardar(@Valid SubCategoria subCat, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Sub Categorias");
			return "formSubCat";
		}
		
		subCategoriaService.save(subCat);
		status.setComplete();
		return "redirect:listarSubCat";
	}
	
	@RequestMapping(value="/eliminarSubCat/{idSubCat}")
	public String eliminar(@PathVariable(value="idSubCat") Long idSubCat) {
		
		if(idSubCat > 0) {
			subCategoriaService.delete(idSubCat);
		}
		return "redirect:/listarSubCat";
	}
}
