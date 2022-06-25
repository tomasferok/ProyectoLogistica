package com.log.app.services.Interfaces;

import java.util.List;

import com.log.app.entidades.Deposito;

public interface IDepositoService {
    
    public List<Deposito> getAllDepositos();

    public Deposito getDepositoById(Long id);

    public Deposito createDeposito(Deposito deposito);

    public Deposito updateDeposito(Deposito deposito);

    public void deleteDeposito(Long id);

}
