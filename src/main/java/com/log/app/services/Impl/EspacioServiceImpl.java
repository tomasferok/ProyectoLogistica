package com.log.app.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.app.daos.IEspacioDao;
import com.log.app.entidades.Espacio;
import com.log.app.services.Interfaces.IEspacioService;


/**
 * Servicio de la entidad Espacio
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Service
public class EspacioServiceImpl implements IEspacioService {
    @Autowired
    private IEspacioDao espacioDao;

    /**
     * @param espacio
     * @return Espacio
     */

    @Override
    public Espacio save(Espacio espacio) {
        // TODO Auto-generated method stub
        return espacioDao.save(espacio);
    }

    /**
     * @param id
     * @return Espacio
     */
    @Override
    public List<Espacio> findAll() {
        // TODO Auto-generated method stub
        return espacioDao.findAll();
    }

    /**
     * @param id
     * @return Espacio
     */

    @Override
    public Espacio findById(Long id) {
        // TODO Auto-generated method stub
        return espacioDao.findById(id).get();
    }

    /**
     * @param id
     */

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        espacioDao.deleteById(id);
    }

    /**
     * @param espacio
     * @return Espacio
     */

    @Override
    public Espacio update(Espacio espacio) {
        // TODO Auto-generated method stub
        return espacioDao.save(espacio);
    }

}
