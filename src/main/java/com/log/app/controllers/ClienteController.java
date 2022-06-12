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

import com.log.app.entidades.Cliente;
import com.log.app.services.Interfaces.IClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

	
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping(value = "/listarCli", method = RequestMethod.GET)
	public String listarCat(Model model) {
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("clientes", clienteService.findAll());
		
		return "listarCat";
		
	}
	@RequestMapping(value = "/formCli")
	public String crearCli(Map<String, Object> model) {

		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Clientes");
		return "formCli";
	}
	@RequestMapping(value="/formCli/{idCliente}")
	public String editarCli(@PathVariable(value="idCliente") Long idCliente, Map<String, Object> model) {
		
		Cliente cliente = null;
		
		if(idCliente > 0) {
			cliente = clienteService.findOne(idCliente);
		} else {
			return "redirect:/listarCli";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "formCli";
	}
	@RequestMapping(value = "/formCli", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Clientes");
			return "formCli";
		}
		
		clienteService.save(cliente);
		status.setComplete();
		return "redirect:listarCli";
	}
	
	@RequestMapping(value="/eliminarCat/{idCliente}")
	public String eliminar(@PathVariable(value="idCliente") Long idCliente) {
		
		if(idCliente > 0) {
			clienteService.delete(idCliente);
		}
		return "redirect:/listarCli";
	}
}


