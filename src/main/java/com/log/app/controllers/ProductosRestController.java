package com.log.app.controllers;

import com.log.app.entidades.Producto;
import com.log.app.services.Impl.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador Rest para la clase Producto
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "*" })
public class ProductosRestController {

    @Autowired
    private ProductoService productosService;

    
    /** 
     * @param producto
     * @return Producto
     */
    @PostMapping("/productos")
    public Producto createProducto(@RequestBody Producto producto) {
        return productosService.save(producto);

    }

    
    /** 
     * @return Iterable<Producto>
     */
    @GetMapping("/productos")
    public Iterable<Producto> getProductos() {
        return productosService.findAll();
    }

    
    /** 
     * @return Iterable<Producto>
     */
    @GetMapping("/productos/disponibles")
    public Iterable<Producto> getProductosDisponibles() {
        return productosService.findProductosDisponibles();
    }

    
    /** 
     * @param id
     * @return Producto
     */
    @GetMapping("/productos/{id}")
    public Producto getProducto(@PathVariable Long id) {
        return productosService.findById(id);
    }

    
    /** 
     * @param "nombre"
     * @param nombre
     * @param "codigoDeBarras"
     * @param codigoDeBarras
     * @return List<Producto>
     */
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

    
    /** 
     * @param producto
     * @return Producto
     */
    @PutMapping("/productos")
    public Producto updateProducto(@RequestBody Producto producto) {
        return productosService.save(producto);
    }

    
    /** 
     * @param id
     */
    @DeleteMapping("/productos/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productosService.delete(id);
    }

}
