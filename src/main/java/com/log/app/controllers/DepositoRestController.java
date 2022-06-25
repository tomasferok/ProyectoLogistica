package com.log.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.app.entidades.Deposito;
import com.log.app.services.Impl.DepositoService;

@RestController
@RequestMapping("/api")
public class DepositoRestController {
    
    @Autowired
    private DepositoService depositoService;

    @GetMapping("/deposito")
    public List<Deposito> getAllDepositos() {

        return depositoService.getAllDepositos();
    }

    @GetMapping("/deposito/{id}")
    public Deposito getDepositoById(@PathVariable Long id) {

        return depositoService.getDepositoById(id);
    }
}
