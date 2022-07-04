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

import com.log.app.entidades.Deposito;
import com.log.app.services.Impl.DepositoService;

/**
 * Controlador Rest para la clase Deposito
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class DepositoRestController {

    @Autowired
    private DepositoService depositoService;

    
    /** 
     * @return List<Deposito>
     */
    @GetMapping("/deposito")
    public List<Deposito> getAllDepositos() {

        return depositoService.getAllDepositos();
    }

    
    /** 
     * @param id
     * @return Deposito
     */
    @GetMapping("/deposito/{id}")
    public Deposito getDepositoById(@PathVariable Long id) {

        return depositoService.getDepositoById(id);
    }

    
    /** 
     * @param deposito
     * @return Deposito
     */
    @PostMapping("/deposito")
    public Deposito createDeposito(@RequestBody Deposito deposito) {

        return depositoService.createDeposito(deposito);
    }

    
    /** 
     * @param deposito
     * @return Deposito
     */
    @PutMapping("/deposito")
    public Deposito updateDeposito(@RequestBody Deposito deposito) {

        return depositoService.updateDeposito(deposito);
    }

    
    /** 
     * @param id
     */
    @DeleteMapping("/deposito/{id}")
    public void deleteDeposito(@PathVariable Long id) {

        depositoService.deleteDeposito(id);
    }

}
