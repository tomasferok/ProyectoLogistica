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

import com.log.app.entidades.Distribuidor;
import com.log.app.services.IDistribuidorService;

@Controller
@SessionAttributes("distribuidor")
public class DistribuidorCotroller {
	@Autowired
	private IDistribuidorService distribuidorService;
	
	@RequestMapping(value = "/listarDist", method = RequestMethod.GET)
	public String listarDist(Model model) {
		model.addAttribute("titulo", "Listado de Distribuidores");
		model.addAttribute("distribuidores", distribuidorService.findAll());
		
		return "listarDist";
		
	}
	@RequestMapping(value = "/formDist")
	public String crearDist(Map<String, Object> model) {

		Distribuidor distribuidor = new Distribuidor();
		model.put("distribuidor", distribuidor);
		model.put("titulo", "Formulario de Distribuidores");
		return "formDist";
	}
	@RequestMapping(value="/formDist/{idDistribu}")
	public String editarDist(@PathVariable(value="idDistribu") Long idDistribu, Map<String, Object> model) {
		
		Distribuidor distribuidor = null;
		
		if(idDistribu > 0) {
			distribuidor = distribuidorService.findOne(idDistribu);
		} else {
			return "redirect:/listarDist";
		}
		model.put("distribuidor", distribuidor);
		model.put("titulo", "Editar Distribuidor");
		return "formDist";
	}
	@RequestMapping(value = "/formDist", method = RequestMethod.POST)
	public String guardar(@Valid Distribuidor distribuidor, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Distribuidores");
			return "formDist";
		}
		
		distribuidorService.save(distribuidor);
		status.setComplete();
		return "redirect:listarDist";
	}
	
	@RequestMapping(value="/eliminarDist/{idDistribu}")
	public String eliminar(@PathVariable(value="idDistribu") Long idDistribu) {
		
		if(idDistribu > 0) {
			distribuidorService.delete(idDistribu);
		}
		return "redirect:/listarDist";
	}
}
