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

import com.log.app.entidades.Proveedor;
import com.log.app.services.Interfaces.IProveedorService;

@Controller
@SessionAttributes("proveedor")
public class ProveedorController {
	@Autowired
	private IProveedorService proveedorService;
	
	@RequestMapping(value = "/listarProv", method = RequestMethod.GET)
	public String listarCat(Model model) {
		model.addAttribute("titulo", "Listado de Proveedores");
		model.addAttribute("proveedores", proveedorService.findAll());
		
		return "listarProv";
		
	}
	@RequestMapping(value = "/formProv")
	public String crearProv(Map<String, Object> model) {

		Proveedor proveedor = new Proveedor();
		model.put("proveedor", proveedor);
		model.put("titulo", "Formulario de Proveedores");
		return "formProv";
	}
	@RequestMapping(value="/formProv/{idProv}")
	public String editarSubCat(@PathVariable(value="idProv") Long idProv, Map<String, Object> model) {
		
		Proveedor proveedor = null;
		
		if(idProv > 0) {
			proveedor = proveedorService.findOne(idProv);
		} else {
			return "redirect:/listarProv";
		}
		model.put("proveedor", proveedor);
		model.put("titulo", "Editar Proveedor");
		return "formProv";
	}
	@RequestMapping(value = "/formProv", method = RequestMethod.POST)
	public String guardar(@Valid Proveedor proveedor, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Proveedores");
			return "formProv";
		}
		
		proveedorService.save(proveedor);
		status.setComplete();
		return "redirect:listarProv";
	}
	
	@RequestMapping(value="/eliminarProv/{idProv}")
	public String eliminar(@PathVariable(value="idProv") Long idProv) {
		
		if(idProv > 0) {
			proveedorService.delete(idProv);
		}
		return "redirect:/listarProv";
	}
}