package com.log.app.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.app.daos.IDepositoDao;
import com.log.app.daos.IEspacioDao;
import com.log.app.daos.IPasilloDao;
import com.log.app.entidades.Deposito;
import com.log.app.services.Interfaces.IDepositoService;

/**
 * Servicio de la entidad Deposito
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */

@Service
public class DepositoService implements IDepositoService {

    @Autowired
    private IDepositoDao depositoDao;

    @Autowired
    private IEspacioDao espacioDao;

    @Autowired
    private IPasilloDao pasilloDao;

    @
    /** 
     * @return List<Deposito>
     */
    Override
    public List<Deposito> getAllDepositos() {
        // TODO Auto-generated method stub
        return depositoDao.findAll();
    }

    @
    /** 
     * @param id
     * @return Deposito
     */
    Override
    public Deposito getDepositoById(Long id) {
        // TODO Auto-generated method stub
        
        return depositoDao.findById(id).get();
    }

    @
    /** 
     * @param deposito
     * @return Deposito
     */
    Override
    public Deposito createDeposito(Deposito deposito) {
        // TODO Auto-generated method stub
       
        return depositoDao.save(deposito);
    }

    @
    /** 
     * @param deposito
     * @return Deposito
     */
    Override
    public Deposito updateDeposito(Deposito deposito) {
        // TODO Auto-generated method stub

        deposito.getPasillos().forEach(pasillo -> {
            pasillo.setDeposito(deposito);
            pasilloDao.save(pasillo);
            pasillo.getEspacio().forEach(espacio -> {
                espacio.setPasillo(pasillo);
                espacioDao.save(espacio);
            });
        });
        return depositoDao.save(deposito);
    }

    @
    /** 
     * @param id
     */
    Override
    public void deleteDeposito(Long id) {
        // TODO Auto-generated method stub
        depositoDao.deleteById(id);
    }

   


}
    

