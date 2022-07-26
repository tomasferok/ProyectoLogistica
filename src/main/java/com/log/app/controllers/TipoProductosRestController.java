package com.log.app.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.log.app.constants.Constants;
import com.log.app.data.ReporteProductosInterface;
import com.log.app.entidades.Producto;
import com.log.app.entidades.TipoProducto;
import com.log.app.helpers.ReporteProductosMasVendidos;
import com.log.app.services.Impl.TipoProductoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Controlador Rest para la clase TipoProducto
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "*" })
public class TipoProductosRestController {
    @Autowired
    private TipoProductoServiceImpl tipoProductosService;

    /**
     * @return List<TipoProducto>
     */
    @GetMapping("/tipoProductos")
    public List<TipoProducto> obtenerTiposProducto() {

        return tipoProductosService.findAll();
    }

    /**
     * @return List<TipoProducto>
     */
    @PostMapping(path = "/tipoProductos")
    public TipoProducto saveTipoProducto(
            @RequestBody() TipoProducto tipoProducto) {
        return tipoProductosService.save(tipoProducto);
    }

    @PostMapping("tipoProductos/image/{tipoProductoNombre}")
    public String saveTipoProducto(
            @RequestParam("image") Optional<MultipartFile> file,
            @PathVariable("tipoProductoNombre") String tipoProductoNombre) {

        return tipoProductosService.saveImage(file, tipoProductoNombre);

    }

    /**
     * @param idProv
     * @return List<TipoProducto>
     */
    @PostMapping("/tipoProductos/prov/")
    public List<TipoProducto> obtenerTiposProductoPorProveedor(@RequestParam("idProv") Long idProv) {

        return tipoProductosService.findByProvedor_IdProv(idProv);
    }

    /**
     * @param nombre
     * @return List<TipoProducto>
     */
    @GetMapping("/tipoProductos/nombre/{nombre}")
    public List<TipoProducto> obtenerTiposProductoPorNombre(@PathVariable("nombre") String nombre) {

        return tipoProductosService.findByNombre(nombre);
    }

    /**
     * @param idProducto
     * @return TipoProducto
     */
    @PostMapping("/tipoProductos/id/{idProducto}")
    public TipoProducto obtenerTipoProductoPorId(@PathVariable("idProducto") Long idProducto) {

        return tipoProductosService.findOne(idProducto);
    }

    /**
     * @param idProducto
     * @return TipoProducto
     */
    @PostMapping("/tipoProductos/cb/{codigoDeBarras}")
    public TipoProducto obtenerTipoProductoPorCodigoDeBarras(@PathVariable("codigoDeBarras") Long idProducto) {

        return tipoProductosService.findOne(idProducto);
    }

    /**
     * @param "nombre"
     * @param nombre
     * @param "codigoDeBarras"
     * @param codigoDeBarras
     * @return List<TipoProducto>
     */
    @PostMapping("/tipoProductos/search/")
    public List<TipoProducto> getProductosByNombre(@RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "codigoDeBarras", required = false) Integer codigoDeBarras) {
        List<TipoProducto> productos = new ArrayList<>();
        if (nombre != null && !nombre.isEmpty()) {
            productos.addAll(tipoProductosService.findByNombre(nombre));
        }
        if (codigoDeBarras != null) {
            productos.add(tipoProductosService.findByCodigoDeBarras(codigoDeBarras));
        }
        return productos;
    }

    /**
     * @param year
     * @return List<ReporteProductosMasVendidos>
     */
    @GetMapping("/tipoProductos/masVendidos/{year}")
    public List<ReporteProductosMasVendidos> obtenerProductosMasVendidos(@PathVariable(name = "year") int year) {

        return tipoProductosService.productosMasVendidos(year);
    }

    /**
     * @param tipoProducto
     * @return TipoProducto
     */
    @PutMapping("/tipoProductos/")
    public void actualizarTipoProducto(@RequestBody TipoProducto tipoProducto) {
        tipoProductosService.update(tipoProducto);
    }

    /**
     * @param id
     */
    @DeleteMapping("/tipoProductos/{id}")
    public void eliminarTipoProducto(@PathVariable("id") Long id) {
        tipoProductosService.delete(id);
    }

}
