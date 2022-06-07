package com.log.app.controllers;

import java.util.List;

import com.log.app.data.Result;
import com.log.app.entidades.TipoProducto;
import com.log.app.services.ITipoProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tipoProductos")
public class TipoProductosRestController {

    @Autowired
    private ITipoProductoService tipoProductosService;

    @CrossOrigin
    @PostMapping("/prov/")
    public List<TipoProducto> obtenerTiposProductoPorProveedor(@RequestParam("idProv") Long idProv) {

        return tipoProductosService.findByProvedor_IdProv(idProv);
    }

    @GetMapping()
    public Result getAllTipoProductos(){
        return tipoProductosService.findAll();
    }

  

}
