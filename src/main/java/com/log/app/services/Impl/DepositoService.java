package com.log.app.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.app.daos.IDepositoDao;
import com.log.app.entidades.Deposito;
import com.log.app.services.Interfaces.IDepositoService;


@Service
public class DepositoService implements IDepositoService {

    @Autowired
    private IDepositoDao depositoDao;

    @Override
    public List<Deposito> getAllDepositos() {
        // TODO Auto-generated method stub
        return depositoDao.findAll();
    }

    @Override
    public Deposito getDepositoById(Long id) {
        // TODO Auto-generated method stub
        return depositoDao.findById(id).get();
    }

    @Override
    public Deposito createDeposito(Deposito deposito) {
        // TODO Auto-generated method stub
        return depositoDao.save(deposito);
    }

    @Override
    public Deposito updateDeposito(Deposito deposito) {
        // TODO Auto-generated method stub
        return depositoDao.save(deposito);
    }

    @Override
    public void deleteDeposito(Long id) {
        // TODO Auto-generated method stub
        depositoDao.deleteById(id);
    }

   


}
    

