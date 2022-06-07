package com.log.app.services;

import com.log.app.data.Result;
import com.log.app.entidades.Recepcion;
import org.codehaus.jettison.json.JSONException;


public interface RecepcionService {

    Result save(Recepcion recepcion);

    Iterable<Recepcion> findAll();

    Result update(Recepcion recepcion, Long id) throws Exception;

    Result getCodeRecepcion();

    Result getStatus(String body) throws JSONException, Exception;
}
