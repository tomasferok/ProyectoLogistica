package com.log.app.controllers;

import com.log.app.entidades.Producto;
import com.log.app.services.Impl.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductosRestController {

    @Autowired
    private ProductoService productosService;

    @PostMapping("/productos")
    public Producto createProducto(@RequestBody Producto producto) {
        return productosService.save(producto);

    }

    @GetMapping("/productos")
    public Iterable<Producto> getProductos() {
        return productosService.findAll();
    }

    @GetMapping("/productos/disponibles")
    public Iterable<Producto> getProductosDisponibles() {
        return productosService.findProductosDisponibles();
    }

    @GetMapping("/productos/{id}")
    public Producto getProducto(@PathVariable Long id) {
        return productosService.findById(id);
    }

    @GetMapping("/productos/search/")
    public List<Producto> getProductosByNombre(@RequestParam(name = "nombre", required = false) String nombre, @RequestParam(name = "codigoDeBarras", required = false) Integer codigoDeBarras) {


        List<Producto> productos
                =  new ArrayList<>();
        if (nombre != null && !nombre.isEmpty()) {
            productos.addAll(productosService.findByNombre(nombre));
        }
        if (codigoDeBarras != null) {
            productos.addAll(productosService.findByCodigoDeBarras(codigoDeBarras));
        }
        return productos;
    }

}
