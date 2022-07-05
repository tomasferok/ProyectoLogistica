package com.log.app.services.Interfaces;

import java.util.List;

import com.log.app.entidades.Espacio;

public interface IEspacioService {
    public Espacio save(Espacio espacio);

    public Espacio findById(Long id);

    public void delete(Long id);

    public Espacio update (Espacio espacio);

    public List<Espacio> findAll();
}
