package com.log.app.controllers;

import com.log.app.data.Result;
import com.log.app.entidades.Producto;
import com.log.app.services.ProductoService;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductosRestController {

    @Autowired
    private ProductoService productosService;

    @PostMapping()
    public Result createProducto(@RequestBody String body) throws Exception{
        return productosService.save(body);

    }

    @GetMapping()
    public Iterable<Producto> getProductos() {
        return productosService.findAll();
    }

    @GetMapping("/productosDisponibles")
    public Iterable<Producto> getProductosDisponibles() {
        return productosService.findProductosDisponibles();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Result updateProducto(@PathVariable("id") Long id, @RequestBody String body) throws Exception {
        return productosService.updateProducto(id, body);
    }

    @PutMapping()
    @ResponseBody
    public Result updateStock(@RequestBody String body) throws JSONException {
        return productosService.updateStock(body);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteProducto(@PathVariable("id") Long id) throws Exception{
        productosService.deleteProducto(id);
    }

    @GetMapping("/stock")
    @ResponseBody
    public Result getStockProductos(){
        return productosService.getStockProductos();
    }


}
