package com.log.app.controllers;

import com.log.app.entidades.Pedido;
import com.log.app.services.Impl.PedidosService;

import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PedidosRestController {
    @Autowired
    private PedidosService pedidosService;

    @PostMapping("/pedidos")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidosService.save(pedido);

    }

    @GetMapping("/pedidos")
    @ResponseStatus(HttpStatus.OK)

    public Iterable<Pedido> getPedidos() {
        return pedidosService.findAll();
    }

    @GetMapping("/pedidos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido getPedido(@PathVariable Long id) {
        return pedidosService.findById(id);
    }

    @PostMapping("/pedidos/cancelar/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido cancelarPedido(@PathVariable("idPedido") Long idPedido, @PathParam("idUsuario") Long idUsuario) {
        return pedidosService.cancelarPedido(idPedido, idUsuario);
    }

    @PutMapping("/pedidos/preparar/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido prepararPedido(@PathVariable("idPedido") Long idPedido,
            @PathParam("idUsuario") Long idUsuario) {
        return pedidosService.prepararPedido(idPedido, idUsuario);
    }

    @PutMapping("/pedidos/controlar/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido controlarPedido(@PathVariable("idPedido") Long idPedido,
            @PathParam("idUsuario") Long idUsuario) {
        return pedidosService.controlarPedido(idPedido, idUsuario);
    }

    @PutMapping("/pedidos/despachar/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido despacharPedido(@PathVariable("idPedido") Long idPedido,
            @PathParam("idUsuario") Long idUsuario, @PathParam("idDistribuidor") Long idDistribuidor) {
        return pedidosService.despacharPedido(idPedido, idUsuario, idDistribuidor);
    }

    @PutMapping("/pedidos/entregar/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido entregarPedido(@PathVariable("idPedido") Long idPedido,
            @PathParam("idUsuario") Long idUsuario) {
        return pedidosService.entregarPedido(idPedido, idUsuario);
    }
    
    @PutMapping("/pedidos/devolver/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido devolverPedido(@PathVariable("idPedido") Long idPedido,
            @PathParam("idUsuario") Long idUsuario) {
        return pedidosService.devolverPedido(idPedido, idUsuario);
    }
}
