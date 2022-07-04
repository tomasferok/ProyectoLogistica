package com.log.app.services.Interfaces;

import java.util.List;

import com.log.app.entidades.Pasillo;

public interface IPasilloService {
    
    public Pasillo save(Pasillo pasillo);
    
    public Pasillo findById(Long id);
    
    public void delete(Long id);
    
    public Pasillo update(Pasillo pasillo);

    public List<Pasillo> findAll();
    

    
}
