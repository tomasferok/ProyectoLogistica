package com.log.app.controllers;

import com.log.app.entidades.Pedido;
import com.log.app.services.Impl.PedidosServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PedidosRestController {

    @Autowired
    private PedidosServiceImpl pedidosService;

    @PostMapping("/pedidos")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidosService.save(pedido);

    }

    @GetMapping("/pedidos")
    public Iterable<Pedido> getPedidos() {
        return pedidosService.findAll();
    }

}
