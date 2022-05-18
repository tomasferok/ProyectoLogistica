package com.log.app.controllers;

import java.util.List;

import com.log.app.Constants;
import com.log.app.entidades.TipoProducto;
import com.log.app.services.TipoProductoServiceImpl;

import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TipoProductosRestController {
    @Autowired
    private TipoProductoServiceImpl tipoProductosService;

    @CrossOrigin
    @PostMapping("/tipoProductos")
    public List<TipoProducto> obtenerTiposProducto() {

        return Constants.tiposProductos;
        // return tipoProductosService.findAll();
    }
}
