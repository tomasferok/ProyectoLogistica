package com.log.app.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.app.daos.IEspacioDao;
import com.log.app.entidades.Espacio;
import com.log.app.services.Interfaces.IEspacioService;


@Service
public class EspacioServiceImpl implements IEspacioService {
@Autowired
private IEspacioDao espacioDao;
    @Override
    public Espacio save(Espacio espacio) {
        // TODO Auto-generated method stub
        return espacioDao.save(espacio);
    }

    @Override
    public Espacio findById(Long id) {
        // TODO Auto-generated method stub
        return espacioDao.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        espacioDao.deleteById(id);
    }

    @Override
    public Espacio update(Espacio espacio) {
        // TODO Auto-generated method stub
        return espacioDao.save(espacio);
    }


    
}
