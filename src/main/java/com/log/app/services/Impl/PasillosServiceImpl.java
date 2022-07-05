package com.log.app.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.log.app.daos.IPasilloDao;
import com.log.app.entidades.Pasillo;
import com.log.app.services.Interfaces.IPasilloService;

/**
 * Servicio de la entidad Pasillo
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
public class PasillosServiceImpl implements IPasilloService {

@Autowired
private IPasilloDao pasilloDao;

    
    /** 
     * @param pasillo
     * @return Pasillo
     */
    @Override
    public Pasillo save(Pasillo pasillo) {
        // TODO Auto-generated method stub
        return pasilloDao.save(pasillo);
    }

    
    /** 
     * @param id
     * @return Pasillo
     */
    @Override
    public Pasillo findById(Long id) {
        // TODO Auto-generated method stub
        return pasilloDao.findById(id).get();
    }

    
    /** 
     * @param id
     */
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        pasilloDao.deleteById(id);
    }

    @Override

    public Pasillo update(Pasillo pasillo) {
        // TODO Auto-generated method stub
        return pasilloDao.save(pasillo);
    }


    @Override
    public List<Pasillo> findAll() {
        // TODO Auto-generated method stub
        return pasilloDao.findAll();
    }
}
