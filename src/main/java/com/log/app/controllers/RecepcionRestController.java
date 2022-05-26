package com.log.app.controllers;

import com.log.app.entidades.Recepcion;
import com.log.app.services.RecepcionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
public class RecepcionRestController {



    @Autowired
    private RecepcionService recepcionService;


    @PostMapping("/recepcion")
    @ResponseStatus(HttpStatus.CREATED)
    public Recepcion createRecepcion(@RequestBody Recepcion recepcion) {
        return recepcionService.save(recepcion);

    }

}