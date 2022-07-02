package com.log.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.app.entidades.Espacio;
import com.log.app.services.Impl.EspacioServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "*" })

public class EspacioRestController {
    @Autowired
    private EspacioServiceImpl espacioService;


    @PostMapping("/espacio")
    public Espacio createEspacio(@RequestBody Espacio espacio) {
        return espacioService.save(espacio);

    }
     @PutMapping("/espacio")
    public Espacio updateEspacio(@RequestBody Espacio espacio) {
        return espacioService.update(espacio);

    }
}
