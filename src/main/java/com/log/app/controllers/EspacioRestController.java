package com.log.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /** 
     * @return List<Espacio>
     */

    @GetMapping("/espacio")
    public List<Espacio> findAll() {
        return espacioService.findAll();
    }

    
    /** 
     * @param espacio
     * @return Espacio
     */
    
    @PostMapping("/espacio")
    public Espacio createEspacio(@RequestBody Espacio espacio) {
        return espacioService.save(espacio);

    }
     
     /** 
      * @param espacio
      * @return Espacio
      */
     @PutMapping("/espacio")
    public Espacio updateEspacio(@RequestBody Espacio espacio) {
        return espacioService.update(espacio);

    }

    @DeleteMapping("/espacio/{id}")
    public void deleteEspacio(@PathVariable Long id) {
        espacioService.delete(id);
    }
}
