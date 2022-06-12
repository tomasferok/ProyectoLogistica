package com.log.app.controllers;

import com.log.app.entidades.Producto;
import com.log.app.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/productosDisponibles")
    public Iterable<Producto> getProductosDisponibles() {
        return productosService.findProductosDisponibles();
    }

    @GetMapping("/productos/{id}")
    public Producto getProducto(@PathVariable Long id) {
        return productosService.findById(id);
    }

    @GetMapping("/productos/nombre/{nombre}")
    public Iterable<Producto> getProductosByNombre(@PathVariable String nombre) {
        return productosService.findByNombre(nombre);
    }

}
