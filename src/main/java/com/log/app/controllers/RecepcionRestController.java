package com.log.app.controllers;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import com.log.app.entidades.Recepcion;
import com.log.app.entidades.RecepcionProducto;
import com.log.app.entidades.TipoEstadoRecepcion;
import com.log.app.exepciones.RecepcionConDiferenciasExeption;
import com.log.app.helpers.CancelarRecepcionRequest;
import com.log.app.helpers.ControlarRecepcionRequest;
import com.log.app.services.RecepcionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

    @GetMapping("/recepcion")
    public Iterable<Recepcion> getRecepciones() {
        return recepcionService.findAll();
    }

    @PostMapping("/controlarRecepcion")
    @ResponseStatus(HttpStatus.OK)
    public Recepcion controlarRecepcion(
            @RequestBody ControlarRecepcionRequest controlarRecepcionRequest) throws RecepcionConDiferenciasExeption {
        System.out.println(controlarRecepcionRequest);

        return recepcionService.recibirRecepcion(controlarRecepcionRequest);

    }

    @PostMapping("/cancelarRecepcion/")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Recepcion cancelarRecepcion(
            @RequestBody CancelarRecepcionRequest cancelarRecepcionRequest) {

        return recepcionService.cancelarRecepcion(cancelarRecepcionRequest);

    }


    @GetMapping("/recepcion/{id}")
    public Recepcion getRecepcion(@PathVariable Long id) {
        return recepcionService.findById(id);
    }


    @ExceptionHandler({ RecepcionConDiferenciasExeption.class })
    public ResponseEntity<Object> loginExeptionHandler(RecepcionConDiferenciasExeption exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }


}