package com.log.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.app.entidades.Espacio;
import com.log.app.services.Impl.EspacioServiceImpl;

/**
 * Controlador Rest para la clase Espacio
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "*" })

public class EspacioRestController {
    @Autowired
    private EspacioServiceImpl espacioService;

    @G
    /** 
     * @return List<Espacio>
     */
    etMapping("/espacio")
    public List<Espacio> getAllEspacios() {
        return espacioService.getAllEspacios();
    }

    @P
    /** 
     * @param espacio
     * @return Espacio
     */
    ostMapping("/espacio")
    public Espacio createEspacio(@RequestBody Espacio espacio) {
        return espacioService.save(espacio);

    }
     @P
     /** 
      * @param espacio
      * @return Espacio
      */
     utMapping("/espacio")
    public Espacio updateEspacio(@RequestBody Espacio espacio) {
        return espacioService.update(espacio);

    }

    @D
    /** 
     * @param id
     */
    eleteMapping("/espacio/{id}")
    public void deleteEspacio(@PathVariable Long id) {
        espacioService.delete(id);
    }
}
