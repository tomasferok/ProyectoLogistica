package com.log.app.controllers;

import com.log.app.entidades.Recepcion;
import com.log.app.services.RecepcionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecepcionController {
    
    @Autowired
    private RecepcionService recepcionService;

    @GetMapping(value = "/crearRecepcion")
    public String login(Model model) {
        model.addAttribute("recepcion", new Recepcion());
        return "crearRecepcion";
    }
}
