package com.log.app.services.Interfaces;

import com.log.app.entidades.Espacio;

public interface IEspacioService {
    public Espacio save(Espacio espacio);

    public Espacio findById(Long id);

    public void delete(Long id);

    public Espacio update (Espacio espacio);
}
