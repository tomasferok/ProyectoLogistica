package com.log.app.controllers;

import java.util.ArrayList;
import java.util.List;

import com.log.app.Constants;
import com.log.app.entidades.Categoria;
import com.log.app.entidades.Producto;
import com.log.app.entidades.Recepcion;
import com.log.app.entidades.TipoProducto;
import com.log.app.services.RecepcionService;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecepcionController {

    @Autowired
    private RecepcionService recepcionService;

    @GetMapping(value = "/crearRecepcion")
    public String crearRecepcion(Model model) {

        // TOOD : traer tipo productos de la base de datos
        model.addAttribute("productos", Constants.tiposProductos);

        model.addAttribute("estadosProducto", Constants.listaEstadosProducto);
        model.addAttribute("recepcion", new Recepcion());
        return "crearRecepcion";
    }

    @PostMapping(value = "/crearRecepcion")
    public String confirmarCreacionRecepcion(Model model) {
        model.addAttribute("recepcion", new Recepcion());
        return "crearRecepcion";
    }
}
