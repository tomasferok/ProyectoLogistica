package com.log.app.services;

import java.util.Iterator;
import java.util.List;

import com.log.app.daos.IRecepcionDao;
import com.log.app.entidades.EstadoRecepcion;
import com.log.app.entidades.Recepcion;
import com.log.app.entidades.RecepcionProducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecepcionService {
    @Autowired
    IRecepcionDao recepcionDao;

    @Autowired
    UserService userService;

    public Iterable<Recepcion> findAll() {
        return recepcionDao.findAll();
    }



    public Recepcion save(Recepcion recepcion) {

        System.out.println("RecepcionService.save()");

        try {
            return recepcionDao.save(recepcion);

        } catch (Exception e) {
            //TODO: handle exceptio
            System.out.println(e.getMessage());
            return null;
        }
    }
}
