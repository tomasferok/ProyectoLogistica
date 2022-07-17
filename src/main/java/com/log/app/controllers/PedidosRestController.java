package com.log.app.controllers;

import com.log.app.data.ReporteCategorias;
import com.log.app.data.ReporteProductosInterface;
import com.log.app.entidades.Categoria;
import com.log.app.entidades.Pedido;
import com.log.app.services.Impl.PedidosService;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador Rest para la clase Pedidos
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "*" })

public class PedidosRestController {
    @Autowired
    private PedidosService pedidosService;

    
    /** 
     * @param pedido
     * @return Pedido
     */
    @PostMapping("/pedidos")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidosService.save(pedido);
    }

    
    /** 
     * @return Iterable<Pedido>
     */
    @GetMapping("/pedidos")
    @ResponseStatus(HttpStatus.OK)

    public Iterable<Pedido> getPedidos() {
        return pedidosService.findAll();
    }

    
    /** 
     * @param id
     * @return Pedido
     */
    @GetMapping("/pedidos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido getPedido(@PathVariable Long id) {
        return pedidosService.findById(id);
    }

    
    /** 
     * @param idPedido
     * @param idUsuario
     * @return Pedido
     */
    @PostMapping("/pedidos/cancelar/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido cancelarPedido(@PathVariable("idPedido") Long idPedido, @PathParam("idUsuario") Long idUsuario) {
        return pedidosService.cancelarPedido(idPedido, idUsuario);
    }

    
    /** 
     * @param @PathVariable("idPedido"
     * @return Pedido
     */
    @PutMapping("/pedidos/preparar/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido prepararPedido(@PathVariable("idPedido") Long idPedido,
            @PathParam("idUsuario") Long idUsuario) {
        return pedidosService.prepararPedido(idPedido, idUsuario);
    }

    
    /** 
     * @param @PathVariable("idPedido"
     * @return Pedido
     */
    @PutMapping("/pedidos/controlar/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido controlarPedido(@PathVariable("idPedido") Long idPedido,
            @PathParam("idUsuario") Long idUsuario) {
        return pedidosService.controlarPedido(idPedido, idUsuario);
    }

    
    /** 
     * @param @PathVariable("idPedido"
     * @return Pedido
     */
    @PutMapping("/pedidos/despachar/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido despacharPedido(@PathVariable("idPedido") Long idPedido,
            @PathParam("idUsuario") Long idUsuario, @PathParam("idDistribuidor") Long idDistribuidor) {
        return pedidosService.despacharPedido(idPedido, idUsuario, idDistribuidor);
    }

    
    /** 
     * @param @PathVariable("idPedido"
     * @return Pedido
     */
    @PutMapping("/pedidos/entregar/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido entregarPedido(@PathVariable("idPedido") Long idPedido,
            @PathParam("idUsuario") Long idUsuario) {
        return pedidosService.entregarPedido(idPedido, idUsuario);
    }
    
    
    /** 
     * @param @PathVariable("idPedido"
     * @return Pedido
     */
    @PutMapping("/pedidos/devolver/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido devolverPedido(@PathVariable("idPedido") Long idPedido,
            @PathParam("idUsuario") Long idUsuario) {
        return pedidosService.devolverPedido(idPedido, idUsuario);
    }

    

    // @GetMapping("/pedidos/categorias/reporte/")
    // @ResponseStatus(HttpStatus.OK)
    // public List<ReporteCategorias> reporteAnualCategoria2() {

    //     return pedidosService.prueba(2022);

    // }
    
    /** 
     * @param year
     * @return List<ReporteProductos>
     */
    @GetMapping("/pedidos/reporte/{year}")
    @ResponseStatus(HttpStatus.OK)
    public List<ReporteProductosInterface> reporteAnual(@PathVariable("year") Integer year) {
        return pedidosService.reporteProductosVendidosAnual(year);
    }

    
    /** 
     * @param year
     * @param idProducto
     * @return List<ReporteProductos>
     */
    @GetMapping("/pedidos/reporte/{year}/")
    @ResponseStatus(HttpStatus.OK)
    public List<ReporteProductosInterface> reporteAnualProducto(@PathVariable("year") Integer year, @RequestParam(name = "idProducto") Long idProducto) {
        return pedidosService.reporteProductoVendidoAnual(year, idProducto);
    }

    /** 
     * @param id
     */
    @DeleteMapping("/pedidos/")
    public void deletePedido(@RequestBody Pedido pedido) {
        pedidosService.delete(pedido);
    }
}
