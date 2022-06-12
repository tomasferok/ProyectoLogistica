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

import com.log.app.entidades.TipoProducto;
import com.log.app.services.Interfaces.ITipoProductoService;

@Controller
@SessionAttributes("tipoProducto")
public class TipoProductoController {
	@Autowired
	private ITipoProductoService tipoProdService;

	@RequestMapping(value = "/listarTipoProd", method = RequestMethod.GET)
	public String listarCat(Model model) {
		model.addAttribute("titulo", "Listado de Tipos de Productos");
		model.addAttribute("tipoProductos", tipoProdService.findAll());

		return "listarTipoProd";

	}

	@RequestMapping(value = "/formTipoProd")
	public String crearCat(Map<String, Object> model) {

		TipoProducto tipoProd = new TipoProducto();
		model.put("tipoProd", tipoProd);
		model.put("titulo", "Formulario de Tipo de Productos");
		return "formTipoProd";
	}

	@RequestMapping(value = "/formTipoProd/{idTipoProd}")
	public String editarSubCat(@PathVariable(value = "idTipoProd") Long idTipoProd, Map<String, Object> model) {

		TipoProducto tipoProd = null;

		if (idTipoProd > 0) {
			tipoProd = tipoProdService.findOne(idTipoProd);
		} else {
			return "redirect:/listarTipoProd";
		}
		model.put("tipoProd", tipoProd);
		model.put("titulo", "Editar Tipo de Producto");
		return "formTipoProd";
	}

	@RequestMapping(value = "/formTipoProd", method = RequestMethod.POST)
	public String guardar(@Valid TipoProducto tipoProd, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Tipo De Productos");
			return "formTipoProd";
		}

		tipoProdService.save(tipoProd);
		status.setComplete();
		return "redirect:listarTipoProd";
	}

	@RequestMapping(value = "/eliminarTipoPord/{idTipoProd}")
	public String eliminar(@PathVariable(value = "idTipoProd") Long idTipoProd) {

		if (idTipoProd > 0) {
			tipoProdService.delete(idTipoProd);
		}
		return "redirect:/listarTipoProd";
	}
}
