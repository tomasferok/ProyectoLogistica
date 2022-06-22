package com.log.app.services.Interfaces;

import java.util.Date;
import java.util.List;

import com.log.app.data.ReporteProductos;
import com.log.app.entidades.Recepcion;
import com.log.app.exepciones.RecepcionConDiferenciasExeption;
import com.log.app.helpers.CancelarRecepcionRequest;
import com.log.app.helpers.ControlarRecepcionRequest;

public interface IRecepcionService {
    public Iterable<Recepcion> findAll();
    public Recepcion save(Recepcion recepcion);
    public Recepcion recibirRecepcion(
            ControlarRecepcionRequest controlarRecepcionRequest) throws RecepcionConDiferenciasExeption;
            
    public long count();
    public Recepcion cancelarRecepcion(Long idUsuario, Long idRecepcion );
    
    public Recepcion findById(Long id);

    public List<ReporteProductos> reporteProductosPedidosAnual(int year);
}
