package com.log.app.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.log.app.constants.Constants;
import com.log.app.data.ReporteProductos;
import com.log.app.entidades.Producto;
import com.log.app.entidades.TipoProducto;
import com.log.app.helpers.ReporteProductosMasVendidos;
import com.log.app.services.Impl.TipoProductoServiceImpl;

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
@CrossOrigin(origins = { "*" })
public class TipoProductosRestController {
    @Autowired
    private TipoProductoServiceImpl tipoProductosService;

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

    @PostMapping("/tipoProductos/search/")
    public List<TipoProducto> getProductosByNombre(@RequestParam(name = "nombre", required = false) String nombre, @RequestParam(name = "codigoDeBarras", required = false) Integer codigoDeBarras) {
        List<TipoProducto> productos
                =  new ArrayList<>();
        if (nombre != null && !nombre.isEmpty()) {
            productos.addAll(tipoProductosService.findByNombre(nombre));
        }
        if (codigoDeBarras != null) {
            productos.add(tipoProductosService.findByCodigoDeBarras(codigoDeBarras));
        }
        return productos;
    }


    @GetMapping("/tipoProductos/masVendidos/{year}")
    public List<ReporteProductosMasVendidos> obtenerProductosMasVendidos(@PathVariable(name = "year") int year
           ) {
       
        return tipoProductosService.productosMasVendidos(year);
    }

}
