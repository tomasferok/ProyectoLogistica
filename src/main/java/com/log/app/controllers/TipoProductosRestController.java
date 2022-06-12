package com.log.app.controllers;

import java.util.List;

import com.log.app.constants.Constants;
import com.log.app.entidades.TipoProducto;
import com.log.app.services.TipoProductoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TipoProductosRestController {
    @Autowired
    private TipoProductoServiceImpl tipoProductosService;

    @CrossOrigin
    @PostMapping("/tipoProductos")
    public List<TipoProducto> obtenerTiposProducto() {

        return tipoProductosService.findAll();
    }

    @CrossOrigin
    @PostMapping("/tipoProductos/prov/")
    public List<TipoProducto> obtenerTiposProductoPorProveedor(@RequestParam("idProv") Long idProv) {

        return tipoProductosService.findByProvedor_IdProv(idProv);
    }

    @CrossOrigin
    @GetMapping("/tipoProductos/nombre/{nombre}")
    public List<TipoProducto> obtenerTiposProductoPorNombre(@PathVariable("nombre") String nombre) {

        return tipoProductosService.findByNombre(nombre);
    }

    @CrossOrigin
    @PostMapping("/tipoProductos/id/{idProducto}")
    public TipoProducto obtenerTipoProductoPorId(@PathVariable("idProducto") Long idProducto) {

        return tipoProductosService.findOne(idProducto);
    }

    @CrossOrigin
    @PostMapping("/tipoProductos/cb/{codigoDeBarras}")
    public TipoProducto obtenerTipoProductoPorCodigoDeBarras(@PathVariable("codigoDeBarras") Long idProducto) {

        return tipoProductosService.findOne(idProducto);
    }

}
