package com.log.app.controllers;

import java.util.List;

import com.log.app.data.Result;
import com.log.app.entidades.Recepcion;
import com.log.app.services.RecepcionService;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/recepcion")
@ResponseBody
public class RecepcionRestController {

    @Autowired
    private RecepcionService recepcionService;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Result createRecepcion(@RequestBody Recepcion recepcion) {
        System.out.println(recepcion.getFechaRecepcion());
        return recepcionService.save(recepcion);
    }

    @GetMapping()
    public Iterable<Recepcion> getRecepciones() {
        return recepcionService.findAll();
    }

    @PutMapping("/{id}")
    public Result updateRecepcion(@PathVariable("id") Long id, @RequestBody Recepcion recepcion) throws Exception{
        return recepcionService.update(recepcion, id);
    }

    @GetMapping("/code")
    public Result getCodeRecepcion(){
        return recepcionService.getCodeRecepcion();
    }

    @PostMapping("/control")
    @ResponseBody
    public Result controlRecepcion(@RequestBody String body) throws JSONException, Exception {
        return recepcionService.getStatus(body);
    }

}