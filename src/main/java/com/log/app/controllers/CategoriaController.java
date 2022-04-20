package com.log.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.log.app.daos.ICategoriaDao;
import com.log.app.entidades.Categoria;



@Controller
public class CategoriaController {

	@Autowired
	@Qualifier("categoriaJPA")
	private ICategoriaDao categoriaDao;
	
	@RequestMapping(value="/listarCat", method=RequestMethod.GET)
	public String listarCat(Model model) {
		
		model.addAttribute("titulo", "Listado Categorias");
		
		model.addAttribute("categorias", categoriaDao.findAll());
		return "listarCat";
	}
	@RequestMapping(value="/formCat")
	public String crearCat(Model model) {
		
		Categoria categoria = new Categoria();
		model.addAttribute("titulo", "Formulario de categorias");
		model.addAttribute("categoria", categoria);
		return "formCat";
	}
	@RequestMapping(value="/formCat", method=RequestMethod.POST)
	public String guardarCat(Categoria categoria) {
		categoriaDao.save(categoria);
		return "redirect:listarCat";
	}
	
}
