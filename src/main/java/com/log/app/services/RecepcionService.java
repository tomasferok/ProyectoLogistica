package com.log.app.services;

import com.log.app.daos.IRecepcionDao;
import com.log.app.entidades.Recepcion;

import org.springframework.stereotype.Service;

@Service
public class RecepcionService {
    IRecepcionDao recepcionDao;

    public void createRecepcion(Recepcion recepcion) {
        recepcionDao.save(recepcion);
    }
}
